package com.ruSkidex.TestGo.SkidexSite;

import com.ruSkidex.HelperClasses.ExecutionСheck;
import com.ruSkidex.ScenariosTests.Search;
import com.ruSkidex.TestControl.Main;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.ruSkidex.Config.Сonfiguration.ADRESS;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class SearchTest extends Main {

    boolean isScenarioSearch;
    private static final Logger log = Logger.getLogger(SearchTest.class);
    Search search = new Search();
    @Test
    public void searchTest() throws IOException {
        try {



        webDriver.get(ADRESS);
        log.info("Страница загрузилась");
        isScenarioSearch = search.scenarioSearch();
        log.info("Сценарий поиска на сайте прошел ");
        ExecutionСheck executionСheck = new ExecutionСheck();
        executionСheck.executionСheck(isScenarioSearch,search.toString());
        }
        catch (Exception e){
            e.printStackTrace();
            ExecutionСheck executionСheck = new ExecutionСheck();
            executionСheck.executionСheck(isScenarioSearch,search.toString());
        }
    }
}
