package com.ruSkidex.Config;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Сonfiguration {


    public final static String ADRESS = "https://tt.skidex.ru/";
    public final static String ADRESS_LEDING = "https://tt-delivery.skidex.ru/";
    public final static String SUSTEM_REP = System.getProperty("user.dir");
    public final static String DRIVER_PATH = SUSTEM_REP + "\\drivers\\chromedriver.log";
    public final static String IMAP_AUTH_EMAIL = "SkidexAutoTest@yandex.ru";
    public final static String IMAP_AUTH_PWD = "cskl19nigypqjexm";
    public final static String IMAP_Server = "imap.yandex.ru";
    public final static String IMAP_Port = "993";

    public final static String LOGIN_ICON_INSTANCE = "//header[@class='header']//div[@class='col-lg-12 header__column']//div[@class='header-panel']//div[@class='header-panel__link-wrapper']//span[@class='header-panel__link']";
    public final static String LOGIN_ICON_INSTANCE_OTHER = "/html/body/div[1]/header/div/div/div/div[3]/div[2]/a";
    public final static String LOGIN_USERNAME = "w.zzzz@mail.ru";
    public final static String LOGIN_PASS = "yq4a6oHY";
    public final static String DRIVER_WiNDOWS = "/drivers/chromedriver.exe";
    public final static String DRIVER_UNIX = "/drivers/chromedriver";
    public static boolean IS_DEPOY_OK = true;

    public static SimpleDateFormat TIMESTAMP = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");


}
