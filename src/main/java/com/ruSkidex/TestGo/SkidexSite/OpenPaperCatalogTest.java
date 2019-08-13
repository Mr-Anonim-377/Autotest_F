package com.ruSkidex.TestGo.SkidexSite;

import com.ruSkidex.HelperClasses.ExecutionСheck;
import com.ruSkidex.ScenariosTests.OpenPaperCatalog;
import com.ruSkidex.TestControl.Main;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class OpenPaperCatalogTest extends Main {
    private static final Logger log = Logger.getLogger(OpenPaperCatalogTest.class);
    private OpenPaperCatalog openPaperCatalog = new OpenPaperCatalog();
    private boolean isOpenPaperCatalogTest;
    @Test
    public void OpenPaperCatalogTest() throws IOException {
        try {



            isOpenPaperCatalogTest = openPaperCatalog.scenarioopenPaperCatalog();
            log.info("Сценарий открытия бумажных катологов прошел");


            ExecutionСheck executionСheck = new ExecutionСheck();
            executionСheck.executionСheck(isOpenPaperCatalogTest,openPaperCatalog.toString());
        }
        catch (Exception e){
            e.printStackTrace();
            ExecutionСheck executionСheck = new ExecutionСheck();
            executionСheck.executionСheck(isOpenPaperCatalogTest,openPaperCatalog.toString());
        }
    }
}
