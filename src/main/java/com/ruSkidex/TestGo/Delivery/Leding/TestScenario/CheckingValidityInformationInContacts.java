package com.ruSkidex.TestGo.Delivery.Leding.TestScenario;

import com.ruSkidex.RestMethod.HttpLocationCheck;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.ProtocolException;

import static com.ruSkidex.Config.Сonfiguration.ADRESS_LEDING;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class CheckingValidityInformationInContacts {
    private boolean isScenarioCheckingValidityInformationInContacts = false;
    private boolean isLocationCheck = false;

    public boolean scenarioCheckingValidityInformationInContacts(Class testClass){
        Logger log = Logger.getLogger(testClass);

        webDriver.get(ADRESS_LEDING);
        log.info("Загрузилась странице лединга");
        WebElement contact = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div[2]/ul/a[1]")); // контакты в лединге на главной странице
        contact.click();
        log.info("Нажата кнопка контакты");
        HttpLocationCheck locationCheck = new HttpLocationCheck();

        try {
            isLocationCheck =  locationCheck.referenceChecking(contact.getAttribute("href"));
            if(isLocationCheck){
                log.info("Странице контактов работает");
            }else{
                log.info("Страница контактов не работает");
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        }


        String phoneOne = webDriver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/div[1]/a[1]")).getText();
        String adress = webDriver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/div[2]/p")).getText();
        String phoneTwo = webDriver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/div[2]/a[1]")).getText();
        String emailOne = webDriver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/div[1]/a[2]")).getText();
        String emailTwo = webDriver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div/div[2]/div[2]/a[2]")).getText();
        String availability = webDriver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div/div[1]/h2")).getText();


        if(phoneOne.contains("+7 (917) 533-51-39")&&
            adress.contains("м. Автозаводская, г. Москва, улица Ленинская Слобода, 19")&&
            phoneTwo.contains("+7 (917) 533-51-39")&&
            emailOne.contains("a.postnikov@skidex.ru") &&
            emailTwo.contains("a.postnikov@skidex.ru") &&
            availability.contains("Мы на связи 5 дней в неделю")&&
            isLocationCheck) {

            isScenarioCheckingValidityInformationInContacts = true;
            log.info("Валидация страницы соблюдена");
        }else{
            log.info("Валдидация страницы не соблюдена");
        }






       return  isScenarioCheckingValidityInformationInContacts;
    }


}
