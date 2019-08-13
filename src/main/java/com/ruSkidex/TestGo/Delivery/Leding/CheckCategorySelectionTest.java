package com.ruSkidex.TestGo.Delivery.Leding;

import com.ruSkidex.HelperClasses.TestCase;
import com.ruSkidex.TestControl.Main;
import com.ruSkidex.TestGo.Delivery.Leding.TestScenario.CheckCategorySelection;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckCategorySelectionTest extends Main {
    private TestCase testCase = new TestCase();
    private CheckCategorySelection checkCategorySelection = new CheckCategorySelection();




    @Test
    private void test() throws IOException {
        testCase.testCase("проверка выбора категорий",
                checkCategorySelection.scenarioCheckCategorySelection(CheckCategorySelectionTest.class),
                checkCategorySelection.toString(),
                CheckCategorySelectionTest.class);

    }

}
