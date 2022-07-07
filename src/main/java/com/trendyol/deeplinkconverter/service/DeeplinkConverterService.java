package com.trendyol.deeplinkconverter.service;

import com.trendyol.deeplinkconverter.entity.LinkEntity;
import com.trendyol.deeplinkconverter.exception.BaseException;
import com.trendyol.deeplinkconverter.model.Link;
import com.trendyol.deeplinkconverter.repository.ConverterRepository;
import com.trendyol.deeplinkconverter.service.todeeplinkconverter.IToDeeplinkConverter;
import com.trendyol.deeplinkconverter.service.todeeplinkconverter.ToDeeplinkConverterFactory;
import com.trendyol.deeplinkconverter.service.tourlconverter.IToURLConverter;
import com.trendyol.deeplinkconverter.service.tourlconverter.ToURLConverterFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DeeplinkConverterService {

    private final ConverterRepository converterRepository;
    private final ToDeeplinkConverterFactory toDeeplinkConverterFactory;
    private final ToURLConverterFactory toURLConverterFactory;

    public Link convertURLToDeeplink(Link URL){
        IToDeeplinkConverter converter = toDeeplinkConverterFactory.getToDeeplinkConverter(URL);
        LinkEntity linkEntity = converter.convert();
        save(linkEntity);
        return new Link(linkEntity.getDeeplink());
    }

    public Link convertDeeplinkToURL(Link deeplink){
        IToURLConverter converter = toURLConverterFactory.getToURLConverter(deeplink);
        LinkEntity linkEntity = converter.convert();
        save(linkEntity);
        return new Link(linkEntity.getUrl());
    }

    @Transactional
    public void save(LinkEntity linkEntity){
        try{
            converterRepository.save(linkEntity);
        }catch (Exception ex){
            throw new BaseException("Could not save convention results.", ex);
        }
    }
}
