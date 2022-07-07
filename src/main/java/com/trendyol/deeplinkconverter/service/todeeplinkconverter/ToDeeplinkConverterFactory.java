package com.trendyol.deeplinkconverter.service.todeeplinkconverter;

import com.trendyol.deeplinkconverter.constant.ConverterConstants;
import com.trendyol.deeplinkconverter.model.Link;

public class ToDeeplinkConverterFactory {

    public IToDeeplinkConverter getToDeeplinkConverter(Link link){
        if(link.getLink().matches(ConverterConstants.REGEX_DEEPLINK_PRODUCT)){
            return new ToDeeplinkProductConverter(link);
        }else if(link.getLink().matches(ConverterConstants.REGEX_DEEPLINK_SEARCH_1) ||
                 link.getLink().matches(ConverterConstants.REGEX_DEEPLINK_SEARCH_2)){
            return new ToDeeplinkSearchConverter(link);
        }else{
            return new ToDeeplinkOtherConverter(link);
        }
    }

}
