package com.ruSkidex.ScenariosTests;

import com.ruSkidex.HelperClasses.Expectation;
import com.ruSkidex.RestMethod.GetRegisterEmail;
import com.ruSkidex.TestControl.DriverMain;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.ProtocolException;

import static com.ruSkidex.Config.Сonfiguration.*;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class Registration {
    private static final Logger log = Logger.getLogger(Registration.class);
    private GetRegisterEmail getEmail = new GetRegisterEmail();
    private Login login = new Login();
    private boolean isAccesCheck = false;
    private String loginUser;
    private boolean isRegistration;



    public boolean registration() throws IOException {
        webDriver.get(ADRESS);
        log.info("Страница загрузилась");
        loginUser = getEmail.getRegisterEmail();
        if(loginUser != null && !loginUser.equals(null)){
            log.info("Получен новая тестовая почта");
        }else{
            log.error("Не получена тестовая почта");
        }
        try {
            if(validRegister()&& invalidRegister()){
                isRegistration = true;
            }

        }catch (Exception e){
            e.printStackTrace();

        }

       return isRegistration;
    }

    private boolean invalidRegister() throws IOException {
        boolean isInvalidRegister = false;
        Expectation.wait(1000);
        login.goPopup();
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[1]/div/div/div/span[2]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[1]/div/div/form[2]/div[2]/div[1]/input")).sendKeys("TestGracheMuche");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[1]/div/div/form[2]/div[2]/div[2]/input")).sendKeys("IAmSuperStars");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[1]/div/div/form[2]/div[2]/div[3]/input")).sendKeys("SuperStars");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[1]/div/div/form[2]")).submit();
        log.info("Успешно прошела попытка ввода при невалидных значений в форму Регистрации");
        String exeptionEmail = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[1]/div/div/form[2]/div[2]/div[2]/div")).getText();


        if(exeptionEmail.trim().equals("Введен невалидный Email")){
            isInvalidRegister = true;
            log.info("Ошибка невалидного email возникла");
        }else{
            log.info("ошибка невалидного email не вазникла");
        }

        return isInvalidRegister;
    }

    private boolean validRegister() throws IOException {
        boolean isValidRegister = false;
        webDriver.get(ADRESS);
        Expectation.wait(1000);
        login.goPopup();
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[1]/div/div/div/span[2]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[1]/div/div/form[2]/div[2]/div[1]/input")).sendKeys("TestGracheMuche");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[1]/div/div/form[2]/div[2]/div[2]/input")).sendKeys(loginUser);
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[1]/div/div/form[2]/div[2]/div[3]/input")).sendKeys("SuperStars");
        log.info("Успешно введены данные в форму регистрации");
        WebElement formRegister = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[1]/div/div/form[2]"));
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[1]/div/div/form[2]/div[3]/button")).click(); // Нажатие на кнопку
        log.info("Нажата кнопка регистрации");
        Expectation.wait(3500);
        login.goPopup();
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div[1]/ul/li[2]/a/p[1]")).click();
        isAccesCheck = login.accessCheck(loginUser);

        if(isAccesCheck){
            isValidRegister = true;
            log.info("Успешно прошла регистрация");
        }else
        {
            log.info("Не успешно прошла регистрация");
        }
        login.goPopup();
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div")).click();
        log.info("Успешно прошел выход из учетной записи");
        Expectation.wait(1000);
        login.scenarioLoginClient(loginUser,"SuperStars");
        log.info("Успешно прошла Авторизация");
        login.goPopup();
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div")).click();
        log.info("Успешно прошел выход из учетной записи после авторизации");

        return isValidRegister;
    }

}
