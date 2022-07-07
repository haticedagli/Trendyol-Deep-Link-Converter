package com.trendyol.deeplinkconverter.service.tourlconverter;

import com.trendyol.deeplinkconverter.constant.ConverterConstants;
import com.trendyol.deeplinkconverter.constant.Page;
import com.trendyol.deeplinkconverter.constant.Scope;
import com.trendyol.deeplinkconverter.entity.LinkEntity;
import com.trendyol.deeplinkconverter.model.Link;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public class ToURLOtherConverter implements IToURLConverter{

    private final Link link;

    public ToURLOtherConverter(Link link){
        this.link = link;
    }

    @Override
    public LinkEntity convert() {
        return generateLinkEntity();
    }

    private LinkEntity generateLinkEntity(){
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setScope(Scope.TO_URL);
        linkEntity.setPage(Page.OTHER);
        linkEntity.setDate(LocalDateTime.now());
        linkEntity.setUrl(generateURL());
        linkEntity.setDeeplink(link.getLink());
        return linkEntity;
    }

    private String generateURL(){
        return ConverterConstants.URL_BASE;
    }
}
