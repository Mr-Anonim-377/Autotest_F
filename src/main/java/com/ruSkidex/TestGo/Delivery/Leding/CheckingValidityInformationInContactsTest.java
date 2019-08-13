package com.ruSkidex.TestGo.Delivery.Leding;

import com.ruSkidex.HelperClasses.TestCase;
import com.ruSkidex.TestControl.Main;
import com.ruSkidex.TestGo.Delivery.Leding.TestScenario.CheckingValidityInformationInContacts;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckingValidityInformationInContactsTest extends Main {


    private CheckingValidityInformationInContacts сheckingValidityInformationInContacts = new CheckingValidityInformationInContacts();
    private TestCase testCase = new TestCase();




    @Test
    private void test() throws IOException {
        testCase.testCase("проверки валдиации контактов",
                                    сheckingValidityInformationInContacts.scenarioCheckingValidityInformationInContacts(CheckingValidityInformationInContactsTest.class),
                                    сheckingValidityInformationInContacts.toString(),
                                    CheckingValidityInformationInContactsTest.class);

    }
}
