package entitys.Content;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContentService {
    public List<Content> getListPost(String urlContent){
        Connection connection = Jsoup.connect(urlContent);
        List<Content> listPost = new ArrayList<>();
        try {
            Document document = connection.get();
            List<Element> elements = document.getElementsByTag("item");
            for (Element el: elements
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
