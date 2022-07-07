package com.trendyol.deeplinkconverter.service.tourlconverter;

import com.trendyol.deeplinkconverter.constant.ConverterConstants;
import com.trendyol.deeplinkconverter.constant.Page;
import com.trendyol.deeplinkconverter.constant.Scope;
import com.trendyol.deeplinkconverter.entity.LinkEntity;
import com.trendyol.deeplinkconverter.exception.ToURLSearchConverterException;
import com.trendyol.deeplinkconverter.model.Link;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public class ToURLSearchConverter implements IToURLConverter{

    private final Link link;

    private String query = null;

    public ToURLSearchConverter(Link link){
        this.link = link;
    }

    @Override
    public LinkEntity convert() {
        try{
            String baseRemoved = link.getLink().replace(String.format("%s%s&", ConverterConstants.DL_BASE, Page.SEARCH.getPage()), "");
            String[] values = baseRemoved.split("&");
            for(String value : values){
                if(value.startsWith(ConverterConstants.DL_QUERY_PARAM)){
                    query = value.replace(ConverterConstants.DL_QUERY_PARAM,"");
                }
            }
            return generateLinkEntity();
        }catch (Exception ex){
            throw new ToURLSearchConverterException("Ops! Something went wrong while converting search deeplink to url.",ex);
        }
    }

    private LinkEntity generateLinkEntity(){
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setScope(Scope.TO_URL);
        linkEntity.setPage(Page.SEARCH);
        linkEntity.setDate(LocalDateTime.now());
        linkEntity.setUrl(generateURL());
        linkEntity.setDeeplink(link.getLink());
        return linkEntity;
    }

    private String generateURL(){
        String url = String.format("%s%s", ConverterConstants.URL_BASE, "/sr");
        if(!StringUtils.isEmpty(query)){
            url = String.format("%s?%s%s", url, ConverterConstants.URL_QUERY_PARAM, query);
        }
        return url;
    }
}
