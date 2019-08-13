package com.ruSkidex.TestGo.SkidexSite;

import com.ruSkidex.HelperClasses.ExecutionСheck;
import com.ruSkidex.ScenariosTests.CheckingPossibilityPurchase;
import com.ruSkidex.TestControl.Main;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckingPossibilityPurchaseTest extends Main {
    private static final Logger log = Logger.getLogger(CheckingPossibilityPurchaseTest.class);
    private boolean isCheckingPossibilityPurchaseTest;
    private CheckingPossibilityPurchase checkingPossibilityPurchase = new CheckingPossibilityPurchase();

      @Test
     public void checkingPossibilityPurchaseTest () throws IOException {
         try {

             isCheckingPossibilityPurchaseTest = checkingPossibilityPurchase.scenarioopenPaperCatalog();
             log.info("Сценарий открытия бумажных катологов прошел");


             ExecutionСheck executionСheck = new ExecutionСheck();
             executionСheck.executionСheck(isCheckingPossibilityPurchaseTest,checkingPossibilityPurchase.toString());
         }
         catch (Exception e){
             e.printStackTrace();
             ExecutionСheck executionСheck = new ExecutionСheck();
             executionСheck.executionСheck(isCheckingPossibilityPurchaseTest,checkingPossibilityPurchase.toString());
         }


     }

}
