package com.ruSkidex.HelperClasses;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Calendar;


import static com.ruSkidex.Config.Сonfiguration.*;

public class ExecutionСheck {
    private  Logger log = Logger.getLogger("ExecutionTest");

    public void executionСheck(boolean isexecutionСheck, String scenario ) throws IOException {


        String [] scenarioParseAraay = scenario.split("@");
        String scenarioPath = scenarioParseAraay[0];

        String [] scenarioPathArray = scenarioPath.split("\\.");
        int indexScenarioPathArrayLeight = scenarioPathArray.length -1;

        if(isexecutionСheck){
            log.info("-------------------------- "+scenarioPathArray[indexScenarioPathArrayLeight]+": = " + "Завершен успешно --------------------------");
        }else{
            log.info("-------------------------- "+scenarioPathArray[indexScenarioPathArrayLeight]+": = " + "Завершен провально --------------------------");
            IS_DEPOY_OK = false;
            throw new IOException("Error: "+scenarioPathArray[indexScenarioPathArrayLeight] + "is not Passes");

        }

    }
}
