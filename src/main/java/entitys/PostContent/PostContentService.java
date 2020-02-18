package entitys.PostContent;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class PostContentService {
    private PostContent postContent = new PostContent();

    public PostContent getContent(String url) {
        System.out.println(url);
        Connection connection = Jsoup.connect(url);
        try {
            Document document = connection.get();
            Element element = document.getElementsByClass("block_detail_news").first() != null ?
                    document.getElementsByClass("block_detail_news").first() : document.getElementsByClass("sidebar_1").first();
            Element el1 = document.getElementsByTag("h1").first();
            postContent.setTieuDe(el1.text());
            postContent.setContent(element.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postContent;
    }
}
