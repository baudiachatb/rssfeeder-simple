package com.example.demojsoup;

import entitys.Content.Content;
import entitys.FacadeService;
import entitys.PostContent.PostContent;
import entitys.rsscontent.RssContent;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/getdata")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RssController {
    private FacadeService facadeService = new FacadeService();


    @GetMapping(value = "/rsscontent")
    public List<RssContent> getRssContent() {
        return facadeService.rssContentService.getAllRssContent();
    }

    @GetMapping("/content")
    public List<Content> getContent(@RequestParam(value = "url") String url) {
        return facadeService.contentService.getListPost("https://vnexpress.net/" + url);
    }

    @GetMapping("/post")
    public PostContent getPost(@RequestParam(value = "url") String url) {
        return facadeService.postContentService.getContent(url);
    }
}
