package com.trendyol.deeplinkconverter.constant;

public class ConverterConstants {

    public static final String URL_BASE = "https://www.trendyol.com";
    public static final String DL_BASE = "ty://?Page=";

    public static final String REGEX_DEEPLINK_PRODUCT =  String.format("%s%s", URL_BASE, "\\/.*\\/.*-p-(?!\\?)[^\\/]*");
    public static final String REGEX_DEEPLINK_SEARCH_1 = String.format("%s%s", URL_BASE, "\\/sr?[^\\/]*");
    public static final String REGEX_DEEPLINK_SEARCH_2 = String.format("%s%s", URL_BASE, "\\/sr");

    public static final String URL_BOUTIQUE_PARAM = "boutiqueId=";
    public static final String URL_MERCHANT_PARAM = "merchantId=";
    public static final String URL_QUERY_PARAM = "q=";

    public static final String DL_CAMPAIGN_PARAM = "CampaignId=";
    public static final String DL_MERCHANT_PARAM = "MerchantId=";
    public static final String DL_CONTENT_ID_PARAM = "ContentId=";
    public static final String DL_QUERY_PARAM = "Query=";

}
