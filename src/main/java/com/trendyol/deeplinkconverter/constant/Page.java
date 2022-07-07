package com.trendyol.deeplinkconverter.constant;

import lombok.Getter;

@Getter
public enum Page {
    PRODUCT("Product"),
    SEARCH("Search"),
    OTHER("Home");

    private String page;

    Page(String page){
        this.page = page;
    }
}
