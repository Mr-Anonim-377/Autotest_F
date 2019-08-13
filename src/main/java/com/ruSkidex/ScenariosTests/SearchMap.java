package com.ruSkidex.ScenariosTests;

import com.ruSkidex.RestMethod.HttpLocationCheck;
import com.ruSkidex.RestMethod.SearchOnMapProduct;
import com.ruSkidex.RestMethod.SearchOnMapShopAdress;
import com.ruSkidex.TestControl.DriverMain;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static com.ruSkidex.Config.Сonfiguration.ADRESS;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class SearchMap {

    private static final Logger log = Logger.getLogger(SearchMap.class);
    boolean isSearcOnhMap;
    boolean isDefoltShop;
    boolean isSearchMap;
    boolean isHttpLocationCheck;
    boolean isScenarioSearchMap;

    HttpLocationCheck httpCheck = new HttpLocationCheck();
    public Boolean scenarioSearchMap() throws IOException {


        WebElement MapButton = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/a"));
        MapButton.click();

        Search search = new Search();
        isSearchMap = search.scenarioSearch();

        webDriver.get(ADRESS);

        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div/div/div/div[3]/a")).click();

        searcOnhMap("pop");

        selectDefaultSales();

        if(isSearcOnhMap&&isDefoltShop&&isSearchMap&&isHttpLocationCheck){
            isScenarioSearchMap = true;

        }
        return isScenarioSearchMap;
    }

    private void selectDefaultSales() throws IOException {

       WebElement defoltShop =  webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/form/div[2]/div/a[1]"));
        defoltShop.click();
        log.info("Нажатие на дефолтный магазин прошле успешно ");
        String defoltShopInSearchLine = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/form/div[1]/div/div")).getText();
        String defoltShopInMap = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/div/a")).getText();
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/div[2]/div/div[1]/div[2]/button")).click();

        isHttpLocationCheck = httpCheck.referenceChecking(webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/div[2]/div/div[3]/div[1]/div[1]/a")).getAttribute("href"));
        if(isHttpLocationCheck) {
            log.info("Ссылки \"Посмотреть товар\" работают");
        }
        else{
            log.info("Ссылки \"Псомотреть товар\" не работают");
        }
        String defoltShopInProduct = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/div[2]/div/div[3]/div[1]/div[1]/div[1]/div/a")).getText();
        if(defoltShop.getText().equals(defoltShopInSearchLine) && defoltShop.getText().equals(defoltShopInMap) && defoltShop.getText().equals(defoltShopInProduct)) {
            isDefoltShop = true;
            log.info("Дефолтные магазины проверены успешно");
        }else{
            log.info("Дефолтные магазины проверены безуспешно");
        }
    }

    private void searcOnhMap(String searchTitle) throws IOException {
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/form/div[1]/input")).sendKeys(searchTitle);
        WebElement searchMapProduct = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/form/div[2]/div[2]/div[2]/div/a[1]/div[2]/span[1]"));
        String titleProduct = searchMapProduct.getText().trim();
        boolean isSearcOnhMapInSearchString = titleProduct.contains(searchTitle);
        if(isSearcOnhMapInSearchString){
            log.info("Верно отображаются 5 первых товаров при поиске");
        }else{
            log.info("Не верно отображаются 5 первых элементов");
        }
        isHttpLocationCheck = httpCheck.referenceChecking(webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/div[2]/div/div[2]/div[1]/div[1]/a")).getAttribute("href"));
        if(isHttpLocationCheck) {
            log.info("Ссылки \"Перейти в магазин\" работают");
        }
        else{
            log.info("Ссылки \"Перейти в магазин\" не работают");
        }
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/form")).submit();
        SearchOnMapShopAdress searchOnMapShopAdress = new SearchOnMapShopAdress();
        String salesAdress = searchOnMapShopAdress.searchOnMapShopAdress("pop");
        String salesMapAdress = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/div[2]/div/div[2]/div/div/p")).getText();
        boolean isSearchOnMapAdress = salesAdress.equals(salesMapAdress);

        if(isSearchOnMapAdress) {
            log.info("Адреса магазинов корректы");
        }
        else{
            log.info("Адресса магазинов не корректны");
        }

        SearchOnMapProduct searchOnMapProduct = new SearchOnMapProduct();
        String productOnMap = searchOnMapProduct.searchOnMapProduct("pop").toLowerCase().trim();

        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/div[2]/div/div[1]/div[2]/button")).click();
        String product = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div[2]/div[2]/div/div[3]/div[1]/div[1]/div[2]/div/span[1]")).getText().toLowerCase().trim();
        String [] productArray  = product.split(" ");
        boolean isSearchMapProduct = false;
        for(String i:productArray) {
             isSearchMapProduct = productOnMap.contains(i);
        }

        if(isSearchMapProduct) {
            log.info("Продукты в магазинах корректны");
        }
        else{
            log.info("Продукты в магазинах не корректны");
        }

        if(isSearcOnhMapInSearchString&&isSearchOnMapAdress&&isSearchMapProduct){
            isSearcOnhMap = true;
            log.info("Поиск по карте успешен");
        }else{
            log.info("Поиск по карте провалился");
        }

    }


}
