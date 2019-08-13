package com.ruSkidex.TestGo.SkidexSite;

import com.ruSkidex.HelperClasses.ExecutionСheck;
import com.ruSkidex.HelperClasses.Expectation;
import com.ruSkidex.ScenariosTests.Login;
import com.ruSkidex.TestControl.Main;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.ruSkidex.Config.Сonfiguration.*;
import static com.ruSkidex.TestControl.DriverMain.webDriver;


public class LoginTest extends Main {

    private boolean isExeption;
    private boolean isScenarioLoginTest = false;
    private static final Logger log = Logger.getLogger(LoginTest.class);
     Login login = new Login();

    @Test
    public void scenarioLoginTest() throws IOException {
        try {


        Login login = new Login();
        login.scenarioLoginClient(LOGIN_USERNAME,LOGIN_PASS);
        log.info("Авторизация сценария авторизации прошла успещно");
        webDriver.get(ADRESS);
        log.info("Страница загрузилась");
        login.goPopup();

        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div")).click();
        log.info("Успешно прошел выход из учетной записи");
        Expectation.wait(1000);

        login.goPopup();

        nonValdyEntry();

        WebElement exeptionLogin =webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div/form[1]/div[2]/div")) ;
        String exeptionLoginString = exeptionLogin.getText();
        log.info("Успешно прошла попытка входа с невалидными данными");

        if(exeptionLogin.isEnabled() && exeptionLoginString.equals("Пользователь с таким email не найден или введен неверный пароль")){
            isExeption = true;
        }
        if(isExeption && login.personalData){
            isScenarioLoginTest = true;
        }
        log.info("Сценарий авторизации прошел ");
        ExecutionСheck executionСheck = new ExecutionСheck();
        executionСheck.executionСheck(isScenarioLoginTest,login.toString());
        }
        catch (Exception e){
            e.printStackTrace();
            ExecutionСheck executionСheck = new ExecutionСheck();
            executionСheck.executionСheck(isScenarioLoginTest,login.toString());
        }
    }


    private void nonValdyEntry(){
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div/form[1]/div[2]/input[1]")).sendKeys("yrtyrtyryr");
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div/form[1]/div[2]/input[2]")).sendKeys("rtyryryrwte");
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div/form[1]/div[3]/button")).click();
    }
}
