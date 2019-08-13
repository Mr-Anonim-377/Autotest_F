package com.ruSkidex.TestGo.SkidexSite;

import com.ruSkidex.HelperClasses.ExecutionСheck;
import com.ruSkidex.ScenariosTests.CityCheck;
import com.ruSkidex.TestControl.Main;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;




public class CityCheckTest extends Main {
    private boolean isCityCheckTest;

    private static final Logger log = Logger.getLogger(CityCheckTest.class);
    private CityCheck cityCheck = new CityCheck();

    @Test
    public void cityCheckTest() throws IOException {
try {


    isCityCheckTest = cityCheck.scenarioCityCheck();
    log.info("Сценарий выбора города прошел ");


    ExecutionСheck executionСheck = new ExecutionСheck();
    executionСheck.executionСheck(isCityCheckTest, cityCheck.toString());


}
catch (Exception e){
    e.printStackTrace();
    ExecutionСheck executionСheck = new ExecutionСheck();
    executionСheck.executionСheck(isCityCheckTest, cityCheck.toString());
}

    }
}
