package com.ruSkidex.ScenariosTests;

import com.ruSkidex.HelperClasses.Expectation;
import com.ruSkidex.RestMethod.HttpLocationCheck;
import com.ruSkidex.TestControl.DriverMain;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.ProtocolException;
import java.util.ArrayList;

import static com.ruSkidex.Config.Сonfiguration.ADRESS;
import static com.ruSkidex.Config.Сonfiguration.LOGIN_ICON_INSTANCE_OTHER;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class CheckingPossibilityPurchase {
    private static final Logger log = Logger.getLogger(CheckingPossibilityPurchase.class);
    private boolean isCheckingPossibilityPurchase;
    ArrayList tabs;


    public boolean scenarioopenPaperCatalog() {


         tabs = new ArrayList (webDriver.getWindowHandles());

        boolean isCpuProduct = cpuProduct();

        webDriver.switchTo().window((String) tabs.get(0));
        log.info("Переход на вкладку 1");

        boolean isCpcProduct = cpcProduct();


        if(isCpuProduct && isCpcProduct){
            isCheckingPossibilityPurchase = true;
        }

        return isCheckingPossibilityPurchase;


    }

    private boolean cpcProduct() {
        boolean isCpcProduct = false;
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        searchTestProduct("Disney Disney Кукла Принцесса: Золушка (37,5 см, подвижн.) (Арт.99542)");

        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/a[1]/div[1]")).click();
        log.info("Переход на страницу товара");


        WebElement clickAddOrder = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/section[1]/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[2]/button"));
        clickAddOrder.click(); // Кнопка добавить в корзину
        log.info("Товар добавлен");
        Expectation.wait(3000);

        checkoutPopUp();

        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[3]/div/div[2]/a")).click(); // Кнопка перейти в корзину
        log.info("Нажата кнопка перейти в корзину");
        String product = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/div/div/div[2]/div[1]/a[2]")).getText().trim().toLowerCase();


        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/div/div/div[3]/a")).click(); // Оформить заказ
        log.info("Нажата кнопка оформить заказ");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/section/form/div[1]/div[1]/div/div[2]/div[1]/input")).sendKeys("89615916917");
        log.info("Введен телефон");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/section/form/div[1]/div[1]/div/div[2]/div[2]/input")).sendKeys("autotest@skidex.ru");
        log.info("Введен емайл ");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/section/form/div[1]/div[1]/div/div[2]/div[3]/input")).sendKeys("Авто Тестовый заказ");
        log.info("Введено имя и фамилия");
        jse.executeScript("window.scrollBy(0,200)", "");
        log.info("Скролл вниз осушествлен");
        WebElement deliveryMethod  = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/section/form/div[1]/div[2]/div/div[2]/div/div/div/input"));
        deliveryMethod.sendKeys("Москва");
        Expectation.wait(1000);
        deliveryMethod.sendKeys(Keys.ARROW_DOWN);
        deliveryMethod.sendKeys(Keys.ENTER);
        log.info("Введен город");
        jse.executeScript("window.scrollBy(0,200)", "");
        log.info("Скролл вниз осушествлен");
        WebElement street = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/section/form/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/input"));
        jse.executeScript("window.scrollBy(0,300)", "");
        log.info("Скролл вниз осушествлен");
        street.sendKeys("ул Ленинская слобода 19");
        Expectation.wait(500);
        street.sendKeys(Keys.ARROW_DOWN);
        street.sendKeys(Keys.ENTER);
        log.info("Введен адресс");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/section/form/div[1]/div[2]/div[2]/div/div[2]/div[2]/input")).sendKeys("5052");
        log.info("Введен номер квартиры");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/section/form/div[1]/div[2]/div[2]/div/div[2]/textarea")).sendKeys("Автотест");
        log.info("Введено сообщение к заказу");
        jse.executeScript("window.scrollBy(0,300)", "");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/section/form/div[2]/div/div/div/div[2]/label/span[1]")).click();
        log.info("Нажата кнопка о принятии соглашения");
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/section/form/div[2]/div/div/div/button")).click();
        log.info("Заказ оформлен");

        WebElement productOnThankspages = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/section[1]/div/div[3]/table/tbody/tr/td[1]/a")); // товар на странице балгодарности





        String  productOnOrder = productOnThankspages.getText().trim().toLowerCase(); // Товар заказа.
        String  companiesOnOrder = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/section[1]/div/div[1]/p")).getText().trim().toLowerCase();// компания  у которой заказ


        boolean isOrderOk = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/section[1]/div/div[1]/h2[2]")).isEnabled() &&
                webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/section[1]/div/div[1]/h2[2]")).getText().contains("Заказ №");

        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/section[1]/div/div[3]/table/tbody/tr/td[1]/a")).click(); // нажатие на сслыку перехода в товар

        String companiesOnProductCart = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/section[1]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/span")).getText().trim().toLowerCase();
        String productOnProductCart = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/section[1]/div/div[2]/div[2]/div[1]/div/div[1]/h1")).getText().trim().toLowerCase();

        boolean isCompaniesOk = companiesOnOrder.contains(companiesOnProductCart);

        if (isCompaniesOk && isOrderOk){
            isCpcProduct = true;
        }
        return isCpcProduct;
    }

    public void checkoutPopUp() {
        Actions builder = new Actions(webDriver);
        builder.moveToElement(webDriver.findElement(By.xpath(LOGIN_ICON_INSTANCE_OTHER))).build().perform();
        builder.moveToElement(webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/div[3]/span"))).build().perform(); // Pop up Корзины
    }
    public boolean cpuProduct(){

        boolean isCpuProduct = false;

        searchTestProduct("SODA BB CREAM #ohbabybaby BB КРЕМ 004 SWEETHEART");

        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/a[1]/div[1]")).click();  // первый продукт из поиска
        WebElement inSale =  webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/section[1]/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/a")); // В магазин на странице товра


        String locationSale = inSale.getAttribute("href" );

        HttpLocationCheck referenceChecking = new HttpLocationCheck();
        boolean isLocationCpuProduct = false;


        try {
            isLocationCpuProduct = referenceChecking.referenceChecking(inSale.getAttribute("href"));
        } catch (ProtocolException e) {
            e.printStackTrace();
            isLocationCpuProduct = false;
        }



        if(isLocationCpuProduct && locationSale.contains("products-fwd") ){

            isCpuProduct = true;
        }

        inSale.click(); // Перейти в магазин
        tabs.add(webDriver.getWindowHandles());
        return isCpuProduct;
    }

    private void searchTestProduct(String product) {
        webDriver.get(ADRESS);
        log.info("Станица загрузилась");

        WebElement inputSearch = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/form/div[1]/input"));

        inputSearch.click(); // Поисковая строка
        inputSearch.sendKeys(product);
        inputSearch.sendKeys(Keys.ENTER);
    }
}
