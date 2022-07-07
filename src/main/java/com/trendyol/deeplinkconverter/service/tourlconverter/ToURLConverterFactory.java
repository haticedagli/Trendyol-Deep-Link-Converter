package com.trendyol.deeplinkconverter.service.tourlconverter;

import com.trendyol.deeplinkconverter.constant.ConverterConstants;
import com.trendyol.deeplinkconverter.constant.Page;
import com.trendyol.deeplinkconverter.model.Link;

public class ToURLConverterFactory {

    public IToURLConverter getToURLConverter(Link link){
        if(link.getLink().startsWith(String.format("%s%s", ConverterConstants.DL_BASE, Page.PRODUCT.getPage()))){
            return new ToURLProductConverter(link);
        }else if(link.getLink().startsWith(String.format("%s%s", ConverterConstants.DL_BASE, Page.SEARCH.getPage()))){
            return new ToURLSearchConverter(link);
        }else{
            return new ToURLOtherConverter(link);
        }
    }
}
