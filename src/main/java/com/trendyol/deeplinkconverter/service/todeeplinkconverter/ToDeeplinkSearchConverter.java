package com.trendyol.deeplinkconverter.service.todeeplinkconverter;

import com.trendyol.deeplinkconverter.constant.ConverterConstants;
import com.trendyol.deeplinkconverter.constant.Page;
import com.trendyol.deeplinkconverter.constant.Scope;
import com.trendyol.deeplinkconverter.entity.LinkEntity;
import com.trendyol.deeplinkconverter.exception.ToDeeplinkProductConverterException;
import com.trendyol.deeplinkconverter.exception.ToDeeplinkSearchConverterException;
import com.trendyol.deeplinkconverter.model.Link;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public class ToDeeplinkSearchConverter implements IToDeeplinkConverter{

    private final Link link;

    private String query = null;

    public ToDeeplinkSearchConverter(Link link){
        this.link = link;
    }

    @Override
    public LinkEntity convert() {
        try{
            String baseRemoved = link.getLink().replace(String.format("%s/", ConverterConstants.URL_BASE), "");
            String[] values = baseRemoved.split("\\?");
            if(values.length > 1){
                query = values[1].replace(ConverterConstants.URL_QUERY_PARAM, "");
            }
            return generateLinkEntity();
        }catch (Exception ex){
            throw new ToDeeplinkSearchConverterException("Ops! Something went wrong while converting search url to deeplink.", ex);
        }
    }

    private LinkEntity generateLinkEntity(){
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setScope(Scope.TO_DEEPLINK);
        linkEntity.setPage(Page.SEARCH);
        linkEntity.setDate(LocalDateTime.now());
        linkEntity.setUrl(link.getLink());
        linkEntity.setDeeplink(generateDeeplink());
        return linkEntity;
    }

    private String generateDeeplink(){
        String deeplink = ConverterConstants.DL_BASE;
        deeplink = String.format("%s%s", deeplink, Page.SEARCH.getPage());
        if(!StringUtils.isEmpty(query)){
            deeplink = String.format("%s&%s%s", deeplink, ConverterConstants.DL_QUERY_PARAM, query);
        }
        return deeplink;
    }
}
