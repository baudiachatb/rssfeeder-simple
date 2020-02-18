package entitys.PostContent;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class PostContentService {
    private PostContent postContent = new PostContent();
    public PostContent getContent(String url){
        System.out.println(url);
        Connection connection = Jsoup.connect(url);
        try {
            Document document = connection.get();
            document.cssSelector();
            Element element = document.getElementsByClass("sidebar_1").first();
            postContent.setTieuDe(element.getElementsByClass("title_news_detail").first().text());
            postContent.setContent(element.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postContent;
    }
}
