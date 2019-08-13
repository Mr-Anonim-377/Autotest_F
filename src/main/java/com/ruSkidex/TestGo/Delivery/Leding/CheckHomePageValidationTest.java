package com.ruSkidex.TestGo.Delivery.Leding;

import com.ruSkidex.HelperClasses.TestCase;
import com.ruSkidex.TestGo.Delivery.Leding.TestScenario.CheckHomePageValidation;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckHomePageValidationTest {

    private TestCase testCase = new TestCase();
    private CheckHomePageValidation checkHomePageValidation = new CheckHomePageValidation();



    @Test
    private void test() throws IOException {
        testCase.testCase("Проверка главной страницы лединга,проверка валидации информации",
                checkHomePageValidation.scenarioCheckHomePageValidation(CheckHomePageValidationTest.class),
                checkHomePageValidation.toString(),
                CheckHomePageValidationTest.class);

    }


}
