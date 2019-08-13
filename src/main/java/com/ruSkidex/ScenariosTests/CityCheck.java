package com.ruSkidex.ScenariosTests;

import com.ruSkidex.HelperClasses.Expectation;
import com.ruSkidex.TestControl.DriverMain;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static com.ruSkidex.Config.Сonfiguration.ADRESS;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class CityCheck {
    String [] cityString = new String[0];
    boolean isTownOK = false;
    private static final Logger log = Logger.getLogger(CityCheck.class);
private boolean isExeptionSelectRown;
    public boolean scenarioCityCheck () {

        webDriver.get(ADRESS);
        log.info("Згрузка страницы прошла успешно");
        enterTown();
        log.info("Город введен");
        Expectation.wait(1000);
        selectedTown();
        Expectation.wait(1000);
        parseUrl();
        log.info("Выбран город успешно");
        checkSelectedTown();
        log.info("Префикс в url верный");

        return isTownOK;
    }

    private  void enterTown() {
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/span/span")).click();
        WebElement inputTown = webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/div/div/input"));
        inputTown.sendKeys("Санкт-Петербург");
    }

    private  void selectedTown(){
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/div/div/input")).sendKeys(Keys.ARROW_DOWN);
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/div/div/input")).sendKeys(Keys.ENTER);
        WebElement cityEnter = webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/button[1]"));
        cityEnter.click();
try {
    webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    isExeptionSelectRown = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[2]/div/div/div[2]/div/div[2]")).isEnabled();
}catch (Exception t) {

    webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
if(isExeptionSelectRown){
    log.error("Введент некорректный город");
}
    }

    private void parseUrl(){
        webDriver.findElement(By.xpath("/html/body/div[1]/section[1]/nav/div/div/a[1]")).click();
        String url = webDriver.getCurrentUrl();
        cityString = url.split("/");
    }

    private void checkSelectedTown(){
        String citeActing = "";
        int countCityString = cityString.length;
        for (int i = 0; i <=countCityString-1;i++){
            if (cityString[i].equals("catalog")){
                citeActing = cityString[i-1];
            }

        }
        if (citeActing.equals("sankt-peterburg")){
            isTownOK = true;
        }
    }

}
