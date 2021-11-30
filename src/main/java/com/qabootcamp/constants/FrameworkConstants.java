package com.qabootcamp.constants;

public class FrameworkConstants {

    private static final String CHROMEDRIVERPATH =  System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver";
    private static final String url =  "https://juice-shop.herokuapp.com/";

    public static String getChromeDriverPath()
    {
        return CHROMEDRIVERPATH;
    }
}
