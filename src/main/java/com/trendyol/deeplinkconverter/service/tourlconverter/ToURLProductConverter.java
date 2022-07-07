package com.trendyol.deeplinkconverter.service.tourlconverter;

import com.trendyol.deeplinkconverter.constant.ConverterConstants;
import com.trendyol.deeplinkconverter.constant.Page;
import com.trendyol.deeplinkconverter.constant.Scope;
import com.trendyol.deeplinkconverter.entity.LinkEntity;
import com.trendyol.deeplinkconverter.exception.ToURLProductConverterException;
import com.trendyol.deeplinkconverter.model.Link;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public class ToURLProductConverter implements IToURLConverter{

    private final Link link;

    private String productId = null;
    private String campaignId = null;
    private String merchantId = null;

    public ToURLProductConverter(Link link){
        this.link = link;
    }

    @Override
    public LinkEntity convert() {
        try{
            String baseRemoved = link.getLink().replace(String.format("%s%s&", ConverterConstants.DL_BASE, Page.PRODUCT.getPage()), "");
            String[] values = baseRemoved.split("&");
            for(String value : values){
                if(value.startsWith(ConverterConstants.DL_CONTENT_ID_PARAM)){
                    productId = value.replace(ConverterConstants.DL_CONTENT_ID_PARAM,"");
                }
                if(value.startsWith(ConverterConstants.DL_CAMPAIGN_PARAM)){
                    campaignId = value.replace(ConverterConstants.DL_CAMPAIGN_PARAM,"");
                }
                if(value.startsWith(ConverterConstants.DL_MERCHANT_PARAM)){
                    merchantId = value.replace(ConverterConstants.DL_MERCHANT_PARAM,"");
                }
            }
            return generateLinkEntity();
        }catch (Exception ex){
            throw new ToURLProductConverterException("Ops! Something went wrong while converting product deeplink to url.",ex);
        }
    }

    private LinkEntity generateLinkEntity(){
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setScope(Scope.TO_URL);
        linkEntity.setPage(Page.PRODUCT);
        linkEntity.setDate(LocalDateTime.now());
        linkEntity.setUrl(generateURL());
        linkEntity.setDeeplink(link.getLink());
        return linkEntity;
    }

    private String generateURL(){
        String url = String.format("%s%s", ConverterConstants.URL_BASE, "/brand/name-p-");
        url = String.format("%s%s", url, productId);
        if(!StringUtils.isEmpty(campaignId) || !StringUtils.isEmpty(merchantId)){
            url = String.format("%s?", url);
            if(!StringUtils.isEmpty(campaignId)){
                url = String.format("%s%s%s", url, ConverterConstants.URL_BOUTIQUE_PARAM, campaignId);
                if(!StringUtils.isEmpty(merchantId)){
                    url = String.format("%s&%s%s", url, ConverterConstants.URL_MERCHANT_PARAM, merchantId);
                }
            }else if(!StringUtils.isEmpty(merchantId)){
                url = String.format("%s%s%s", url, ConverterConstants.URL_MERCHANT_PARAM, merchantId);
            }
        }
        return url;
    }
}
