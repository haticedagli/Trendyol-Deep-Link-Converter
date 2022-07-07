package com.trendyol.deeplinkconverter.service.todeeplinkconverter;

import com.trendyol.deeplinkconverter.constant.ConverterConstants;
import com.trendyol.deeplinkconverter.constant.Page;
import com.trendyol.deeplinkconverter.constant.Scope;
import com.trendyol.deeplinkconverter.entity.LinkEntity;
import com.trendyol.deeplinkconverter.exception.ToDeeplinkProductConverterException;
import com.trendyol.deeplinkconverter.model.Link;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

public class ToDeeplinkProductConverter implements IToDeeplinkConverter{

    private final Link link;

    private String productId = null;
    private String boutiqueId = null;
    private String merchantId = null;

    public ToDeeplinkProductConverter(Link link){
        this.link = link;
    }

    @Override
    public LinkEntity convert() {
        try{
            String baseRemoved = link.getLink().replace(String.format("%s/", ConverterConstants.URL_BASE), "");
            String[] values = baseRemoved.split("/");
            values = values[1].split("\\?");
            String[] values2 = values[0].split("-p-");
            productId = values2[1];
            if(values.length>1){
                values = values[1].split("&");
                for (String value : values) {
                    if (value.startsWith(ConverterConstants.URL_BOUTIQUE_PARAM)) {
                        boutiqueId = value.replace(ConverterConstants.URL_BOUTIQUE_PARAM, "");
                    }
                    if (value.startsWith(ConverterConstants.URL_MERCHANT_PARAM)) {
                        merchantId = value.replace(ConverterConstants.URL_MERCHANT_PARAM, "");
                    }
                }
            }
            return generateLinkEntity();
        }catch (Exception ex){
            throw new ToDeeplinkProductConverterException("Ops! Something went wrong while converting product url to deeplink.",ex);
        }
    }

    private LinkEntity generateLinkEntity(){
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setScope(Scope.TO_DEEPLINK);
        linkEntity.setPage(Page.PRODUCT);
        linkEntity.setDate(LocalDateTime.now());
        linkEntity.setUrl(link.getLink());
        linkEntity.setDeeplink(generateDeeplink());
        return linkEntity;
    }

    private String generateDeeplink(){
        String deeplink = ConverterConstants.DL_BASE;
        deeplink = String.format("%s%s", deeplink, Page.PRODUCT.getPage());
        deeplink = String.format("%s&%s%s", deeplink, ConverterConstants.DL_CONTENT_ID_PARAM, productId);
        if(!StringUtils.isEmpty(boutiqueId)){
            deeplink = String.format("%s&%s%s", deeplink, ConverterConstants.DL_CAMPAIGN_PARAM, boutiqueId);
        }
        if(!StringUtils.isEmpty(merchantId)){
            deeplink = String.format("%s&%s%s", deeplink, ConverterConstants.DL_MERCHANT_PARAM, merchantId);
        }
        return deeplink;
    }
}
