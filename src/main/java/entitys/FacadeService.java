package entitys;

import entitys.Content.ContentService;
import entitys.PostContent.PostContentService;
import entitys.rsscontent.RssContentService;

public class FacadeService {
    public ContentService contentService = new ContentService();
    public PostContentService postContentService = new PostContentService();
    public RssContentService rssContentService = new RssContentService();
}
