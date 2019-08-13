package com.ruSkidex.TestGo.Delivery.Leding.TestScenario;

import com.ruSkidex.HelperClasses.Expectation;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.ruSkidex.Config.Сonfiguration.ADRESS_LEDING;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class AddProductToOrder {
        boolean isAddProductToOrder;
        boolean isAddOneProduct;
        boolean isAddSomeProduct;
        boolean isButtonOnOrderShow;
        boolean isRemoveProduct;
        boolean isCountProduct;
        boolean isPriceAllOnProduct;

    public boolean scenarioAddProductToOrder(Class testClass){

        Logger log = Logger.getLogger(testClass);

        webDriver.get(ADRESS_LEDING);
        log.info("Загрулизась страница лединга");

        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/a")).click(); // Второй магазин по горизонтали
        log.info("Переход в магазин");
        WebElement productOneInOrder = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[3]/div[1]/div[1]/div/div[2]/button"));
        String buttonString  = productOneInOrder.getText();
        productOneInOrder.click();
        log.info("Добавление товара в заказ");

        WebElement productRemoval = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/div[1]/div/div[2]/div/button[1]"));
        WebElement productAdd = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/div[1]/div/div[2]/div/button[2]"));
        WebElement amountProduct = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/div[1]/div/div[2]/div/div/span[1]"));
        WebElement priceAllProduct = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/div[1]/div/div[2]/span"));
        WebElement priceOnOrder = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[3]/div[2]/span"));
        String [] priceAllCountProductArray = priceAllProduct.getText().split(" ");

        if(amountProduct.getText().contains("1 шт.") && priceAllProduct.getText().contains(priceOnOrder.getText())){
            isAddOneProduct = true;
            log.info("Товар добавился правильно");
        }else{
            log.info("Товар добавился неверно ");
        }

        productAdd.click();
        log.info("Добавление еще одного экземпляра выбранного твара в заказ");

        double priceAllCountProduct = Double.valueOf(priceAllCountProductArray[0]) * 2;

        if(amountProduct.getText().contains("2 шт.") && priceAllProduct.getText().contains(String.valueOf(priceAllCountProduct)) && priceAllProduct.getText().contains(priceOnOrder.getText())  )
        {
            isAddSomeProduct = true;
            log.info("Добавление еще одного экземпляра в товар прошло успешно");
        }else {
            log.info("Добавление еще одного экземпляра в товар прошло не успешно");

        }


        productRemoval.click();
        log.info("Удаление экзепляра товара ");

        if(amountProduct.getText().contains("1 шт.") && priceAllProduct.getText().contains(priceAllCountProductArray[0]) && priceAllProduct.getText().contains(priceOnOrder.getText())){

            isRemoveProduct = true;
            log.info("Удаление прошло успешно ");
        }else{
            log.info("Удаление прошло не успешно ");

        }


        productRemoval.click();
        log.info("Удаление всех экземпляров товара");

        String priceOnOrderText = priceOnOrder.getText();

        Actions action = new Actions(webDriver);
        action.moveToElement(webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/div[2]/div/div[2]/button"))).build().perform();
        // мув на соседний товар
        String buttonAddOrder = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/div[1]/div/div[2]/button")).getText(); // первый товар в лединге

        if(buttonAddOrder.contains("В корзину")&& priceOnOrderText.contains("0.00")){

            isButtonOnOrderShow = true;
            log.info("Удаление всех экземплярров товара прошло успешно");
        }else {
            log.info("Удаление всех экземплярров товара прошло не успешно");

        }


        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/div[1]/div/div[2]/button")).click(); // первый товар а странице
        log.info("Добавление первого товара на странице лединга");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[2]/div[2]/div/div[2]/button")).click(); // второй товар на странице лединга
        log.info("Добавление второго товар");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/a")).click(); // переход во все твоары
        log.info("Переход во все товары ресторана");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div[2]/button")).click(); // выбор первого товара из страницы со всеми товарами
        log.info("Добавление товара со страницы со всеми товарами");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div[2]/div/button[2]")).click(); // выбор первого товара из страницы со всеми товарами еще раз
        log.info("Добавление еще одного экзмепляра товара ");

        String countProduct = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[3]/div[2]/div")).getText();


        if(countProduct.equals("3")){
            isCountProduct = true;
            log.info("Товары добавились верно ");
        }else {
            log.info("Товары добавились  не верно ");

        }

        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[3]/div[2]")).click(); // переход в корзину
        log.info("Переход в корзину ");

        Expectation.wait(100);
        String[] periceOnOrderAllProductArray = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[4]/div/div[2]/div/div[3]/span")).getText().split(" ");


        String[] periceOnOrderOneProductArray = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[4]/div/div[2]/div/div[1]/div[1]/div[2]/div/span")).getText().split(" ");
        String[] periceOnOrderTwoProductArray = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[4]/div/div[2]/div/div[1]/div[2]/div[2]/div/span")).getText().split(" ");
        String[] periceOnOrderThreeProductArray = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[4]/div/div[2]/div/div[1]/div[3]/div[2]/div/span")).getText().split(" ");


        double periceOnOrderAllProduct = Double.valueOf(periceOnOrderAllProductArray[0]);


        double periceOnOrderOneProduct = Double.valueOf(periceOnOrderOneProductArray[0]);
        double periceOnOrderTwoProduct = Double.valueOf(periceOnOrderTwoProductArray[0]);
        double periceOnOrderThreeProduct = Double.valueOf(periceOnOrderThreeProductArray[0]);




        if(periceOnOrderAllProduct == periceOnOrderOneProduct+periceOnOrderTwoProduct+periceOnOrderThreeProduct){

            isPriceAllOnProduct = true;
            log.info("В корзине верная валидация товаров");
        }else {
            log.info("В корзине не верная валидация товаров");

        }

        if( isAddOneProduct && isAddSomeProduct&& isButtonOnOrderShow&& isRemoveProduct&& isCountProduct&& isPriceAllOnProduct)
        {

            isAddProductToOrder = true;
            log.info("Добавление товаров в заказ корректно");
        }else{
            log.info("Добавление товаров в заказ не корректно");

        }





        return isAddProductToOrder;
    }
}
