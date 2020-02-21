package services;

import entitys.Content.Content;
import entitys.PostContent.PostContent;
import entitys.rsscontent.RssContent;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DantriGetContentService implements GetContent {
    private PostContent postContent = new PostContent();

    @Override
    public List<RssContent> getAllRssContent(String page) {
        Connection connection = Jsoup.connect(page);
        List<RssContent> list = new ArrayList<>();
        try {
            Document document = connection.get();
            List<Element> elements = document.getElementsByClass("child");
            if (!elements.isEmpty()) {
                for (Element el : elements
                ) {
                    RssContent rssContent = new RssContent(el.getElementsByTag("b").first().text(), el.getElementsByTag("a").first().attr("href"));
                    list.add(rssContent);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list.isEmpty() ? Collections.emptyList() : list;
    }

    @Override
    public PostContent getContent(String url) {
        Connection connection = Jsoup.connect("https://dantri.com.vn" + url);
        try {
            Document document = connection.get();
            Element element = document.getElementById("ctl00_IDContent_Tin_Chi_Tiet") != null ?
                    document.getElementById("ctl00_IDContent_Tin_Chi_Tiet") : document.getElementsByClass("sidebar_1").first();
            Element el1 = document.getElementsByTag("h1").first();
            postContent.setTieuDe(el1.text());
            element.getElementsByClass("fl").remove();
            element.getElementsByClass("box26").first().remove();
            element.getElementsByClass("mt2").first().remove();
            element.getElementsByTag("h1").first().remove();
            element.getElementsByTag("h2").first().getElementsByTag("b").remove();
            Element content = new Element("div");
            Element firstImage = element.getElementsByClass("image").first();
            Element description = element.getElementsByTag("h2").first();
            if (firstImage.getElementsByTag("figcaption").first() != null) {
                firstImage.getElementsByTag("figcaption").remove();
            }
            if (firstImage != null) {
                if (firstImage.getElementsByTag("p").first() != null) {
                    firstImage.getElementsByTag("p").first().remove();
                }
                content.appendChild(firstImage);
            }
            if (description != null) {
                if (!description.getElementsByTag("span").isEmpty()) {
                    description.getElementsByTag("span").remove();
                }

                content.appendChild(description);
            }
//            content.appendChild(element);
            postContent.setContent(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postContent;
    }

    @Override
    public List<Content> getListPost(String urlContent) {
        Connection connection = Jsoup.connect(urlContent.replace("rss", "htm"));
        List<Content> listPost = new ArrayList<>();
        try {
            Document document = connection.get();
            List<Element> elements = document.getElementsByClass("mt3");
            for (Element el : elements
            ) {
                String title = el.getElementsByTag("a").first().attr("title");
                String url = el.getElementsByTag("a").first().attr("href");
                listPost.add(new Content(title, url));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listPost;
    }
}
