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
    public List<RssContent> getRssContent(@RequestParam(value = "page") String page) {
        switch (page) {
            case "vnexpress":
                return facadeService.vnExpressGetContentService.getAllRssContent("https://vnexpress.net/rss");
            case "dantri":
                return facadeService.dantriGetContentService.getAllRssContent("https://dantri.com.vn/rss.htm");
            default:
                return facadeService.vnExpressGetContentService.getAllRssContent("https://vnexpress.net/rss");
        }
    }

    @GetMapping("/content")
    public List<Content> getContent(@RequestParam(value = "url") String url, @RequestParam(value = "page") String page) {
        switch (page) {
            case "dantri":
                return facadeService.dantriGetContentService.getListPost("https://dantri.com.vn/" + url);
            case "vnexpress":
                return facadeService.vnExpressGetContentService.getListPost("https://vnexpress.net/" + url);
            default:
                return facadeService.vnExpressGetContentService.getListPost("https://vnexpress.net/" + url);
        }

    }

    @GetMapping("/post")
    public PostContent getPost(@RequestParam(value = "url") String url, @RequestParam(value = "page") String page) {
        switch (page) {
            case "dantri":
                return facadeService.dantriGetContentService.getContent(url);
            case "vnexpress":
                return facadeService.vnExpressGetContentService.getContent(url);
            default:
                return facadeService.vnExpressGetContentService.getContent(url);
        }
    }
}
