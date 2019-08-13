package com.ruSkidex.TestGo.SkidexSite;

import com.ruSkidex.HelperClasses.ExecutionСheck;
import com.ruSkidex.ScenariosTests.Registration;
import com.ruSkidex.TestControl.Main;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTest extends Main {


    private static final Logger log = Logger.getLogger(RegistrationTest.class);
    private Registration registration = new Registration();
    private boolean isRegistrTest = false;

    @Test
    public void scenarioRegistration() throws IOException {
try {



        isRegistrTest = registration.registration();
        log.info("Сценарий регистрации прошел");


        ExecutionСheck executionСheck = new ExecutionСheck();
        executionСheck.executionСheck(isRegistrTest,registration.toString());
}
catch (Exception e){
    e.printStackTrace();
    ExecutionСheck executionСheck = new ExecutionСheck();
    executionСheck.executionСheck(isRegistrTest,registration.toString());
}
    }
}
