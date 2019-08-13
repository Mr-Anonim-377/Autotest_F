package com.ruSkidex.ScenariosTests;

import com.ruSkidex.HelperClasses.Expectation;
import com.ruSkidex.RestMethod.PasswordMail;
import com.ruSkidex.TestControl.DriverMain;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.mail.MessagingException;
import java.io.IOException;

import static com.ruSkidex.Config.Сonfiguration.*;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class PassvordRecovery {
    private static final Logger log = Logger.getLogger(PassvordRecovery.class);
    private Login login = new Login();
    public String scenarioPassvordRecovery(String usersLogin) throws IOException, MessagingException {
        String newPassword = null;
        webDriver.get(ADRESS);
        log.info("Страница загрузилась");
        Expectation.wait(1000);
        login.goPopup();

        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div/form[1]/div[3]/span")).click();
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div/form[3]/div[1]/input")).sendKeys(usersLogin);
        WebElement recoveryEmailButton  = webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div/form[3]/div[2]/button"));
        recoveryEmailButton.click();
        Expectation.wait(3000);
        String titleRecovery = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[1]/div/div/form[3]/p")).getText().trim();
        if ( titleRecovery.equals("Ссылка для восстановления пароля успешно отправлена на вашу эл. почту.")){
            log.info("Заявка восстановления пароля успешно отправлена");
        }else{
            throw new IOException("Error: application not formed ");
        }

        Expectation.wait(2000);
        try {
            PasswordMail password = new PasswordMail();
            newPassword = password.passMail(IMAP_AUTH_EMAIL, IMAP_AUTH_PWD, IMAP_Server, IMAP_Port);
        }
        catch (IOException e){
            try {
                Expectation.wait(7000);
                PasswordMail password = new PasswordMail();
                newPassword = password.passMail(IMAP_AUTH_EMAIL, IMAP_AUTH_PWD, IMAP_Server, IMAP_Port);
            }
            catch (IOException E){
                throw new IOException("Error: mail search");
            }
            }

        log.info("Письмо доставленно, новый пароль получен");
        return newPassword;

    }


}