package Pozzie.controllers;

import Pozzie.services.PositionCheckerService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@Component
public class CheckerController {

    @Autowired
    private PositionCheckerService positionCheckerService;

    @RequestMapping("/check/{keyword}")
    @ResponseBody
    public List<String> get10Results(@PathVariable("keyword") String keyword){
        ArrayList<String> list = new ArrayList<String>();

        String url = "https://www.google.com/search?q=" + keyword;
        int connectionTimeoutMs = 10000;

        Document document;
        try{
            document = Jsoup.parse(new URL(url), connectionTimeoutMs);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        Elements elements = document.getElementsByClass("iUh30");
        return elements.eachText();
    }

    @RequestMapping("/check/{keyword}/{url}")
    @ResponseBody
    public int getPositionfrom10results(@PathVariable("keyword") String keyword, @PathVariable("url") String url){
        return positionCheckerService.checkPosition(keyword, url);
    }
}
