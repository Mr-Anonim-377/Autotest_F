package com.ruSkidex.ScenariosTests;

import com.ruSkidex.TestControl.DriverMain;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static com.ruSkidex.Config.Сonfiguration.*;
import static com.ruSkidex.TestControl.DriverMain.webDriver;


public class SearchCensorship {
    private static final Logger log = Logger.getLogger(SearchCensorship.class);

    public boolean scenarioSearchCensorship() throws IOException {
        boolean banerEnable;


        webDriver.get(ADRESS);
        log.info("Страница загрузилась");
        WebElement searchLine = webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/form/div[1]/input"));
        searchLine.sendKeys("лак");
        log.info("Строка поиска гна сайте работает");

        WebDriverWait wait = new WebDriverWait(webDriver,20);
        searchLine = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='header__form search active']//span[@class='search__checkbox-text checkbox-text']")));

        WebElement button = webDriver.findElement(By.xpath("//form[@class='header__form search active']//span[@class='search__checkbox-text checkbox-text']"));

        button.click();
        log.info("Нажата кнопка 18+");
        String i = webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/form/div[4]/div/div[1]/span")).getText();

        banerEnable = webDriver.findElement(By.xpath("//form[@class='header__form search active']//div[@class='search__years-inner']")).isEnabled();

        return banerEnable;

    }
}
