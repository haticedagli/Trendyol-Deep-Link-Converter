package com.trendyol.deeplinkconverter.controller;

import com.trendyol.deeplinkconverter.model.Link;
import com.trendyol.deeplinkconverter.service.DeeplinkConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/converter")
@RequiredArgsConstructor
public class DeeplinkController {

    private final DeeplinkConverterService deeplinkConverterService;

    @PostMapping("/to-deeplink")
    public ResponseEntity<Link> convertURLToDeeplink(@RequestBody Link URL){
        return ResponseEntity.status(HttpStatus.OK).body(deeplinkConverterService.convertURLToDeeplink(URL));
    }

    @PostMapping("/to-url")
    public ResponseEntity<Link> convertDeeplinkToURL(@RequestBody Link deeplink){
        return ResponseEntity.status(HttpStatus.OK).body(deeplinkConverterService.convertDeeplinkToURL(deeplink));
    }

}

