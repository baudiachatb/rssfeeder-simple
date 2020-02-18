package com.example.demojsoup;

import entitys.FacadeService;
import entitys.PostContent.PostContent;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class DemojsoupApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemojsoupApplication.class, args);
//        FacadeService facadeService = new FacadeService();
//        facadeService.rssContentService.getAllRssContent().forEach(a -> {
//            System.out.println(a.getTieuDe());
//            System.out.println(a.getUrlRss());
//        });
//        facadeService.contentService.getListPost("https://vnexpress.net"+"/rss/tin-moi-nhat.rss").forEach(post -> {
//            System.out.println(post.getTitle());
//            System.out.println(post.getUrl());
//        });
//        String url = "https://vnexpress.net/the-gioi/bam-tru-ho-bac-vi-khong-muon-dua-ncov-ve-chau-phi-4056187.html";
//        PostContent content = facadeService.postContentService.getContent(url);
//        System.out.println(content.getTieuDe());
//        System.out.println(content.getContent());
    }

}
