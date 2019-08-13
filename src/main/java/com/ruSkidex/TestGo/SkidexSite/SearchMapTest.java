package com.ruSkidex.TestGo.SkidexSite;

import com.ruSkidex.HelperClasses.ExecutionСheck;
import com.ruSkidex.ScenariosTests.SearchMap;
import com.ruSkidex.TestControl.Main;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.ruSkidex.Config.Сonfiguration.ADRESS;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class SearchMapTest extends Main {

    boolean isScenarioSearchMap;
    private static final Logger log = Logger.getLogger(SearchMapTest.class);
    private SearchMap searchMap = new SearchMap();


    @Test
    public void searchMapTest() throws IOException {
        try {
            webDriver.get(ADRESS);
            log.info("Загрузка страницы прошла успешно");
            isScenarioSearchMap = searchMap.scenarioSearchMap();
            log.info("Сценарий проверки карты прошел ");
            ExecutionСheck executionСheck = new ExecutionСheck();
             executionСheck.executionСheck(isScenarioSearchMap,searchMap.toString());
            }
        catch (Exception e){
            e.printStackTrace();
            ExecutionСheck executionСheck = new ExecutionСheck();
            executionСheck.executionСheck(isScenarioSearchMap,searchMap.toString());
        }
    }
}

