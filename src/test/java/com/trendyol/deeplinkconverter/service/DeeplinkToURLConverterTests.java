package com.trendyol.deeplinkconverter.service;

import com.trendyol.deeplinkconverter.model.Link;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeeplinkToURLConverterTests {

    @Autowired
    private DeeplinkConverterService deeplinkConverterService;

    @Test
    public void test(){
        Link request = new Link("ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064");
        String expected = "https://www.trendyol.com/brand/name-p-1925865?boutiqueId=439892&merchantId=105064";
        Link result = deeplinkConverterService.convertDeeplinkToURL(request);
        assertEquals(result.getLink(), expected);
    }

    @Test
    public void test2(){
        Link request = new Link("ty://?Page=Product&ContentId=1925865");
        String expected = "https://www.trendyol.com/brand/name-p-1925865";
        Link result = deeplinkConverterService.convertDeeplinkToURL(request);
        assertEquals(result.getLink(), expected);
    }

    @Test
    public void test3(){
        Link request = new Link("ty://?Page=Product&ContentId=1925865&CampaignId=439892");
        String expected = "https://www.trendyol.com/brand/name-p-1925865?boutiqueId=439892";
        Link result = deeplinkConverterService.convertDeeplinkToURL(request);
        assertEquals(result.getLink(), expected);
    }

    @Test
    public void test4(){
        Link request = new Link("ty://?Page=Product&ContentId=1925865&MerchantId=105064");
        String expected = "https://www.trendyol.com/brand/name-p-1925865?merchantId=105064";
        Link result = deeplinkConverterService.convertDeeplinkToURL(request);
        assertEquals(result.getLink(), expected);
    }

    @Test
    public void test5(){
        Link request = new Link("ty://?Page=Search&Query=elbise");
        String expected = "https://www.trendyol.com/sr?q=elbise";
        Link result = deeplinkConverterService.convertDeeplinkToURL(request);
        assertEquals(result.getLink(), expected);
    }

    @Test
    public void test6(){
        Link request = new Link("ty://?Page=Search&Query=%C3%BCt%C3%BC");
        String expected = "https://www.trendyol.com/sr?q=%C3%BCt%C3%BC";
        Link result = deeplinkConverterService.convertDeeplinkToURL(request);
        assertEquals(result.getLink(), expected);
    }

    @Test
    public void test7(){
        Link request = new Link("ty://?Page=Favorites");
        String expected = "https://www.trendyol.com";
        Link result = deeplinkConverterService.convertDeeplinkToURL(request);
        assertEquals(result.getLink(), expected);
    }

    @Test
    public void test8(){
        Link request = new Link("ty://?Page=Orders");
        String expected = "https://www.trendyol.com";
        Link result = deeplinkConverterService.convertDeeplinkToURL(request);
        assertEquals(result.getLink(), expected);
    }
}
