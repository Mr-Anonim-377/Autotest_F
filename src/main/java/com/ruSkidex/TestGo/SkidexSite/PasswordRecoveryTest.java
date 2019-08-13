package com.ruSkidex.TestGo.SkidexSite;

import com.ruSkidex.HelperClasses.ExecutionСheck;
import com.ruSkidex.HelperClasses.Expectation;
import com.ruSkidex.ScenariosTests.Login;
import com.ruSkidex.ScenariosTests.PassvordRecovery;
import com.ruSkidex.TestControl.Main;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.ruSkidex.Config.Сonfiguration.ADRESS;
import static com.ruSkidex.Config.Сonfiguration.IMAP_AUTH_EMAIL;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class PasswordRecoveryTest extends Main { ;
    private boolean isScenarioPassvordRecoveryTest;
    private static final Logger log = Logger.getLogger(PasswordRecoveryTest.class);
    PassvordRecovery passvordRecovery = new PassvordRecovery();
    Login login = new Login();

    @Test
    public void scenarioPassvordRecoveryTest() throws IOException {
        try {



        String newPassword = passvordRecovery.scenarioPassvordRecovery(IMAP_AUTH_EMAIL);
        log.info("Восстановление пароля в сценарии восстановления пароля прошло успешно");

        login.scenarioLoginClient(IMAP_AUTH_EMAIL,newPassword);

        log.info("Авторизация сценария восстановления пароля прошла успещно");
            Expectation.wait(2000);
        login.goPopup();

        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div[1]/div[2]/div")).click();
        log.info("Выход из учетной записи прошел успешно");
        webDriver.get(ADRESS);
        log.info("Страница загрузилась");
        isScenarioPassvordRecoveryTest = login.personalData;
        log.info("Сценарий Восстановления пароля прошел ");



        ExecutionСheck executionСheck = new ExecutionСheck();
        executionСheck.executionСheck(isScenarioPassvordRecoveryTest,passvordRecovery.toString());
        }
        catch (Exception e){
            e.printStackTrace();
            ExecutionСheck executionСheck = new ExecutionСheck();
            executionСheck.executionСheck(isScenarioPassvordRecoveryTest,passvordRecovery.toString());
        }
    }



}