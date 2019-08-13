package com.ruSkidex.TestGo.Delivery.Leding;

import com.ruSkidex.HelperClasses.TestCase;
import com.ruSkidex.TestControl.Main;
import com.ruSkidex.TestGo.Delivery.Leding.TestScenario.CheckingAddressOnMainVellage;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckingAddressOnMainVellageTest extends Main {
    private TestCase testCase = new TestCase();
     private CheckingAddressOnMainVellage checkingAddressOnMainVellage = new CheckingAddressOnMainVellage();



    @Test
    private void test() throws IOException {
        testCase.testCase("проверка адреса на главной станице лединга",
                checkingAddressOnMainVellage.scenarioCheckingAddressOnMainVellage(CheckingValidityInformationInContactsTest.class),
                checkingAddressOnMainVellage.toString(),
                CheckingValidityInformationInContactsTest.class);

    }


}
