package com.ruSkidex.TestGo.Delivery.Leding.TestScenario;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.ruSkidex.Config.Сonfiguration.ADRESS_LEDING;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class CheckingAddressOnMainVellage {
    private boolean isCheckingAddressOnMainVellage = false;


    public boolean scenarioCheckingAddressOnMainVellage(Class testClass){

        Logger log = Logger.getLogger(testClass);

        webDriver.get(ADRESS_LEDING);
        log.info("Загрузилась страница лединга");
        WebElement adress = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div[2]/span/span"));
        String adressString = adress.getText();
        adress.click();
        log.info("Переход на фрейм карты");


        String adressOnFrame = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div[3]/div/div[1]/h3/b")).getText(); // текст адресса на фрейме карты


if(adressString.contains(adressOnFrame)){
    isCheckingAddressOnMainVellage = true;
    log.info("Правильный адресс");


}else{
    log.info("Не правильный адресс");

}





        return isCheckingAddressOnMainVellage;
    }
}
