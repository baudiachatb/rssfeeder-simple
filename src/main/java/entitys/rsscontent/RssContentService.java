package entitys.rsscontent;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RssContentService {
    private Connection connection = Jsoup.connect("https://vnexpress.net/rss");


    public List<RssContent> getAllRssContent() {
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
}
