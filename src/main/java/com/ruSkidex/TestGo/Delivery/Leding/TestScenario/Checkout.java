package com.ruSkidex.TestGo.Delivery.Leding.TestScenario;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.ruSkidex.Config.Сonfiguration.ADRESS_LEDING;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class Checkout {
        boolean isCheckout;
    private AddProductToOrder addProductToOrder = new AddProductToOrder();

        public boolean scenarioCheckout(Class testClass){
            Logger log = Logger.getLogger(testClass);

            webDriver.get(ADRESS_LEDING);
            log.info("Загрулизась страница лединга");

            boolean isAddProduct = addProductToOrder.scenarioAddProductToOrder(testClass);


            webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[4]/div/div[2]/div/div[4]/button[1]")).click();
            log.info("Нажата кнопка оформления заказа");

            webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[4]/div/div[2]/div/form/div[2]/input")).sendKeys("5");
            log.info("Введен номер этажа ");

            webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[4]/div/div[2]/div/form/div[3]/input")).sendKeys("Test");
            log.info("Введен Офис");

            webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[4]/div/div[2]/div/form/div[4]/input")).sendKeys("AutoTest");
            log.info("Введено имя ");

            webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[4]/div/div[2]/div/form/div[5]/input")).sendKeys("9999999999");
            log.info("Введен номер телефона");

            webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[4]/div/div[2]/div/form/div[6]/textarea")).sendKeys("Test");
            log.info("Введен комментарий");



            String thanks = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[4]/div/div[2]/div/div[1]/p")).getText().trim();
            log.info("Появилась лагодарочка");

            if (thanks.contains("Спасибо за заказ!")&& isAddProduct){
                isCheckout = true;
                log.info("Заказ состоялся, благодарочка появилась");
            }else
            {
                log.info("Заказ не состоялся, благодарочка не появилась");

            }



    return isCheckout;
    }
}
