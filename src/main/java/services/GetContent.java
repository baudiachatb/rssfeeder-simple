package services;

import entitys.Content.Content;
import entitys.PostContent.PostContent;
import entitys.rsscontent.RssContent;

import java.util.List;

public interface GetContent {
    public List<RssContent> getAllRssContent(String page);
    public PostContent getContent(String url);
    public List<Content> getListPost(String urlContent);
}
