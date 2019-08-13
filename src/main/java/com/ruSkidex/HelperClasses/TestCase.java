package com.ruSkidex.HelperClasses;

import com.ruSkidex.TestControl.Main;
import org.apache.log4j.Logger;

import java.io.IOException;

public class TestCase {

    private boolean isTestCase;


    public void testCase(String TestName,boolean isTestCase, String testClassName, Class testClass) throws IOException {
        Logger log = Logger.getLogger(testClass);
        this.isTestCase = isTestCase;
        try {
        log.info("Сценарий "+ TestName+ " прошел");

        ExecutionСheck executionСheck = new ExecutionСheck();
        executionСheck.executionСheck(this.isTestCase,testClassName);
    }
         catch (Exception e){
        e.printStackTrace();
        ExecutionСheck executionСheck = new ExecutionСheck();
        executionСheck.executionСheck(this.isTestCase,testClassName);
    }

    }


}
