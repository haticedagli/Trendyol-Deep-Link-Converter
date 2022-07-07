package com.trendyol.deeplinkconverter.service.todeeplinkconverter;

import com.trendyol.deeplinkconverter.constant.ConverterConstants;
import com.trendyol.deeplinkconverter.constant.Page;
import com.trendyol.deeplinkconverter.constant.Scope;
import com.trendyol.deeplinkconverter.entity.LinkEntity;
import com.trendyol.deeplinkconverter.model.Link;

import java.time.LocalDateTime;

public class ToDeeplinkOtherConverter implements IToDeeplinkConverter{

    private final Link link;

    public ToDeeplinkOtherConverter(Link link){
        this.link = link;
    }

    @Override
    public LinkEntity convert() {
        return generateLinkEntity();
    }

    private LinkEntity generateLinkEntity(){
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setScope(Scope.TO_DEEPLINK);
        linkEntity.setPage(Page.OTHER);
        linkEntity.setDate(LocalDateTime.now());
        linkEntity.setUrl(link.getLink());
        linkEntity.setDeeplink(generateDeeplink());
        return linkEntity;
    }

    private String generateDeeplink(){
        String deeplink = ConverterConstants.DL_BASE;
        deeplink = String.format("%s%s", deeplink, Page.OTHER.getPage());
        return deeplink;
    }
}
