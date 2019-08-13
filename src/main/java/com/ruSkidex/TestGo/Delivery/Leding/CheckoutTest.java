package com.ruSkidex.TestGo.Delivery.Leding;

import com.ruSkidex.HelperClasses.TestCase;
import com.ruSkidex.TestControl.Main;
import com.ruSkidex.TestGo.Delivery.Leding.TestScenario.Checkout;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutTest extends Main {

    private TestCase testCase = new TestCase();
    private Checkout checkout = new Checkout();




    @Test
    private void test() throws IOException {
        testCase.testCase("проверка выбора категорий",
                checkout.scenarioCheckout(CheckoutTest.class),
                checkout.toString(),
                CheckoutTest.class);

    }


}
