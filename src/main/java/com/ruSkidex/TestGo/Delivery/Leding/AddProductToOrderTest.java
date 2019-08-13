package com.ruSkidex.TestGo.Delivery.Leding;

import com.ruSkidex.HelperClasses.TestCase;
import com.ruSkidex.TestControl.Main;
import com.ruSkidex.TestGo.Delivery.Leding.TestScenario.AddProductToOrder;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddProductToOrderTest extends Main {

    private TestCase testCase = new TestCase();
    private AddProductToOrder addProductToOrder = new AddProductToOrder();




    @Test
    private void test() throws IOException {
        testCase.testCase("проверки Добавление товара в заказ",
                addProductToOrder.scenarioAddProductToOrder(AddProductToOrderTest.class),
                addProductToOrder.toString(),
                AddProductToOrderTest.class);

    }
}
