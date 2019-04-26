package Pozzie.services;

import Pozzie.model.KeyWord;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PositionCheckerServiceImpl implements PositionCheckerService {

    @Autowired
    KeyWordService keyWordService;

    @Autowired
    PositionService positionService;

    @Override
    public int checkPosition(String keyWord, String url) {
        String googleSearch = "https://www.google.com/search?q=" + keyWord;
        int connectionTimeoutMs = 10000;
        Pattern compiledPattern = Pattern.compile(url);
        Matcher matcher = null;
        Document document;
        try{
            document = Jsoup.parse(new URL(googleSearch), connectionTimeoutMs);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        Elements elements = document.getElementsByClass("iUh30");
        List<String> urls = elements.eachText();
        for(String link : urls){
            matcher = compiledPattern.matcher(link);
            if(matcher.find()){
                return urls.indexOf(link)+1; //index from 0
            }
        }
        return 0;
    }

    @Override
    public String checkAllPositions() {
        Random random = new Random();
        Iterable<KeyWord> keyWords = keyWordService.getAllKeywords();
        String aaa = "";
        int actualPosition = 0;
        for(KeyWord keyWord : keyWords){
            actualPosition = checkPosition(keyWord.getKeyword(), "olx");
            positionService.addPosition(random.nextInt(), new Date(2019, 04, 25), actualPosition, keyWord.getProject().getProjectUrl(), keyWord);
            aaa += keyWord.getKeyword() + actualPosition + "\n";
        }
        return aaa;
    }
}
