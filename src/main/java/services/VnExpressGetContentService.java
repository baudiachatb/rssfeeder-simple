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

public class VnExpressGetContentService implements GetContent {
    private PostContent postContent = new PostContent();

    @Override
    public List<RssContent> getAllRssContent(String page) {
        Connection connection = Jsoup.connect(page);
        List<RssContent> list = new ArrayList<>();
        try {
            Document document = connection.get();
            List<Element> elements = document.getElementsByClass("rss_txt");
            if (!elements.isEmpty()) {
                for (Element el : elements
                ) {
                    RssContent rssContent = new RssContent(el.text(), el.attr("href"));
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
        Connection connection = Jsoup.connect(url);
        try {
            Document document = connection.get();
            Element element = document.getElementsByClass("block_detail_news").first() != null ?
                    document.getElementsByClass("block_detail_news").first() : document.getElementsByClass("sidebar_1").first();
            Element title = document.getElementsByTag("h1").first();
            List<Element> listImage = element.getElementsByTag("table");
            Element description = element.getElementsByClass("description").first();
            element.getElementsByClass("clearfix").remove();
            Element el = new Element("div");
            if (!listImage.isEmpty()) {
                Element firstImage = listImage.get(0);
                if (firstImage.getElementsByTag("tr").size()>1) {
                    firstImage.getElementsByTag("tr").get(1).remove();
                }
                el.appendChild(firstImage);
            }
            if(title != null){
                el.appendChild(title);
            }
            if(description != null){
                el.appendChild(description);
            }

//            el.appendChild(element);
            postContent.setTieuDe(title.text());
            postContent.setContent(el.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postContent;
    }

    @Override
    public List<Content> getListPost(String urlContent) {
        Connection connection = Jsoup.connect(urlContent);
        List<Content> listPost = new ArrayList<>();
        try {
            Document document = connection.get();
            List<Element> elements = document.getElementsByTag("item");
            for (Element el : elements
            ) {
                String title = el.getElementsByTag("title").first().text();
                String url = el.getElementsByTag("link").first().text();
                listPost.add(new Content(title, url));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listPost;
    }
}
