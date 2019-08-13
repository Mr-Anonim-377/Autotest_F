package com.ruSkidex.ScenariosTests;

import com.ruSkidex.RestMethod.MethodSearch;
import com.ruSkidex.TestControl.DriverMain;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static com.ruSkidex.Config.Сonfiguration.*;
import static com.ruSkidex.TestControl.DriverMain.webDriver;


public class Search {

    private  String searchProductString;
    private static final Logger log = Logger.getLogger(Search.class);


    public  boolean scenarioSearch()throws IOException  {
        boolean searchCorrect = false;
        String title;


        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/form/div[1]/input")).sendKeys("kit");
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/form/div[1]/input")).sendKeys(Keys.ENTER);
        log.info("Поиск по товарам выполнен");
        title = webDriver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[2]/div[2]/a[1]/p[1]")).getText();

        MethodSearch searchProduct = new MethodSearch();
        searchProductString = searchProduct.search("kit");



        if(title.equals(searchProductString)){
            searchCorrect = true;
            log.info("Поиск прошел верно");

        }



        return searchCorrect;
    }
    }

