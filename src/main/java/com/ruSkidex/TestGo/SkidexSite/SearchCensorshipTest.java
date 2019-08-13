package com.ruSkidex.TestGo.SkidexSite;

import com.ruSkidex.HelperClasses.ExecutionСheck;
import com.ruSkidex.ScenariosTests.SearchCensorship;
import com.ruSkidex.TestControl.Main;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchCensorshipTest extends Main {
    boolean isScenarioSearchCensorship;
    private static final Logger log = Logger.getLogger(SearchCensorshipTest.class);
    SearchCensorship searchCensorship = new SearchCensorship();
    @Test
    public void searchCensorshipTest() throws IOException {
        try {


        SearchCensorship searchCensorship = new SearchCensorship();
        isScenarioSearchCensorship = searchCensorship.scenarioSearchCensorship();

        log.info("Сценарий проверки поиска взрослых штучек пиздюками прошел ");
        ExecutionСheck executionСheck = new ExecutionСheck();
        executionСheck.executionСheck(isScenarioSearchCensorship,searchCensorship.toString());
        }
        catch (Exception e){
            e.printStackTrace();
            ExecutionСheck executionСheck = new ExecutionСheck();
            executionСheck.executionСheck(isScenarioSearchCensorship,searchCensorship.toString());
        }

    }
}
