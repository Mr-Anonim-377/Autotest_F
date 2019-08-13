package com.ruSkidex.ScenariosTests;

import com.google.gson.Gson;
import com.ruSkidex.RestMethod.Gson.Reqest.RpcMessage;
import com.ruSkidex.RestMethod.Gson.Reqest.RpcPaperCatalogProductListPayload;
import com.ruSkidex.RestMethod.Gson.RpcPaperCatalogProductGson;
import com.ruSkidex.RestMethod.HTTPMethodRpc;
import com.ruSkidex.RestMethod.HttpLocationCheck;
import com.ruSkidex.TestControl.DriverMain;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;

import java.net.ProtocolException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.ruSkidex.Config.Сonfiguration.ADRESS;
import static com.ruSkidex.Config.Сonfiguration.IMAP_AUTH_EMAIL;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class OpenPaperCatalog {
    private static final Logger log = Logger.getLogger(OpenPaperCatalog.class);
    private HttpLocationCheck locationCheck = new HttpLocationCheck();
    private boolean isLocationCheck;
    private boolean isOpenPaperCatalogCkript;
    private boolean isVaidationProductPaperCatalogs;
    private boolean isOpenPaperCatalog;
    private  boolean isSubscription;

    public boolean scenarioopenPaperCatalog (){
        webDriver.get(ADRESS);
        log.info("Страница загрузилась");

        WebElement allPaperCatalog = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[3]/a"));
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollBy(0,250)", "");

        allPaperCatalog.click(); // Показать все бум каталоги на главной странице
        log.info("Открылись все бум каталоги");
        WebElement urlPaperCatalog;
        WebElement paperCatalog = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div[3]/div/a[1]/div/div[1]"));

        int numberProduct = 0;

        paperCatalog.click(); // первый каталог из всех каталогов
        log.info("Выбран первый бум каталог");
        isOpenPaperCatalog = true;

        String urlPaperCatalogProduct = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/div[1]/a[1]")).getAttribute("href"); // первый тавар бумажного каталога
        WebElement currentProduct = null;
        String paperCatalogId = "";

        try {
            isLocationCheck = locationCheck.referenceChecking(urlPaperCatalogProduct);
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        if(isLocationCheck){
            currentProduct = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/div[1]/a[1]"));
            currentProduct.click(); // первый товар бумажного кталога
            log.info("Открыт товар бумажного каталога ");
             numberProduct = 0;
             urlPaperCatalog = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/a"));// ссылка на станице товара бумажного каталога
            String[] paperCatalogUrlArray = urlPaperCatalog.getAttribute("href").split("/");
             paperCatalogId = paperCatalogUrlArray[4];
            urlPaperCatalog.click(); // Ссылка на бум каталог товара
            log.info("Переход в бум каталог ");
        }else{
            urlPaperCatalogProduct = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/div[2]")).getAttribute("href");
            try {
                log.error("Первый товар не открылся");
                isLocationCheck = locationCheck.referenceChecking(urlPaperCatalogProduct); // второй товар бумажного каталога
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            log.error("Ссылка на товар не валидна,выбираем другой ");

            if(isLocationCheck){
                currentProduct = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/div[2]"));
                currentProduct.click(); // второй товар бумажного каталога
                log.info("Открытие другого товара бумажного каталога ");
                numberProduct = 1;
                 urlPaperCatalog = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/a"));
                    String[] paperCatalogUrlArray = urlPaperCatalog.getAttribute("href").split("/");
                     paperCatalogId = paperCatalogUrlArray[4];
                 urlPaperCatalog.click(); // Ссылка на бум каталог товара
                log.info("Переход в бум каталог");
            }else{
                try {
                    throw new Exception("Не валидна ссылка на товар бум каталога ");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            }

//            if(numberProduct == 0 ){
//                currentProduct = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/div[1]/a[1]"));
//                currentProduct.click(); // первый товар бумажного кталога
//            } else{
//                currentProduct = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/div[2]"));
//                currentProduct.click(); // второй товар бумажного каталога
//            }
//
//                isVaidationProductPaperCatalogs = VaidationProductPaperCatalogs(paperCatalogId, numberProduct);
//
//        Когда переделают страницу бом катлаогов будет проверка валидации на странице.



        //isSubscription = subscription(); // будет реализован после изменения старницы бум каталога

if(isLocationCheck && isOpenPaperCatalog /*&& isVaidationProductPaperCatalogs&& isSubscription*/){
    isOpenPaperCatalogCkript = true;
    log.info("Бумажный каталог открывается корректно");

}else{
    isOpenPaperCatalogCkript = false;
    log.info("Бумажный каталог открывается не корректно");

}

        return isOpenPaperCatalogCkript;
    }

    private boolean subscription() {
        boolean isSubscription = false;
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[5]/div[2]/form/input")).sendKeys(IMAP_AUTH_EMAIL); // поле ввода для подписки
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[5]/div[2]/form/button")).click(); // Кнопика подписаться
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div")).click(); // Кнопка закрытия pop up с кукой
        String subscriptionAdded = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[5]/div[2]/div/p")).getText().trim();
        if (subscriptionAdded.equals("Подписка оформлена!")){
            log.info("Подписка оформленна");
            isSubscription = true;
        }else{
            isSubscription = false;
        log.error("Поджписка не оформлена");
        }

return isSubscription;
    }

    private boolean VaidationProductPaperCatalogs(String paperCatalogId, int numberProduct) {
        boolean isVaidationProductPaperCatalogs = false;
        RpcMessage paperCatalogProductListReq = new RpcMessage();
        Gson g = new Gson();
        String RpcJsonReq;
        paperCatalogProductListReq.setMessages(paperCatalogProductListSetMessage(
                Integer.valueOf(paperCatalogId),
                1,
                "price",
                "ASC",
                "paperCatalogProductList"));

        RpcJsonReq = g.toJson(paperCatalogProductListReq);

        HTTPMethodRpc htttpRpc = new HTTPMethodRpc();
        String answerRpcPaperCatalogProduct = htttpRpc.getRpcMethodAnswer(RpcJsonReq);
        RpcPaperCatalogProductGson.MethodPaperCatalogsProductsRPC methodPaperCatalogsProductsRPC = g.fromJson(answerRpcPaperCatalogProduct, RpcPaperCatalogProductGson.MethodPaperCatalogsProductsRPC.class);
        RpcPaperCatalogProductGson.Payload payload = methodPaperCatalogsProductsRPC.getMessages().get(numberProduct).getPayload();
        RpcPaperCatalogProductGson.Product product = payload.getProducts().get(0);
        float priceResp = product.getPrice();
        String productPaperCatalogResp = product.getTitle();
        String paperCatalogResp = payload.getCatalogs().get(0).getTitle();
        int discontResp = product.getDiscount();
        float oldPriceResp = product.getOldPrice();
        String dateBeginsAtResp = product.getBeginsAt();
        String dateEndsAtResp = product.getEndsAt();


        WebElement priceWebElement = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/div/div[1]/div[2]/div[1]/div[2]/span[1]"));
        String[] priceWebElementArray =  priceWebElement.getText().split(" ");
        float priceOnPage = Float.parseFloat(priceWebElementArray[0]);

        WebElement productPaperCatalogWebElement = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[1]/div/div/h1"));
        String [] productPaperCatalogWebElementArray = productPaperCatalogWebElement.getText().split(",");
        String productPaperCatalogOnPages = productPaperCatalogWebElementArray[0];

        WebElement paperCatalogWebElement = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/a"));

        WebElement discontWebElement = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/div/div[1]/div[2]/div[1]/div[1]"));
        String [] discontWebElementArray = discontWebElement.getText().split("-");
        int discontOnPages = Integer.parseInt(discontWebElementArray[1]);

        WebElement oldPriceWebElement = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/div/div[1]/div[2]/div[1]/div[2]/span[2]"));
        String[] oldPriceWebElementArray =  oldPriceWebElement.getText().split(" ");
        float oldPriceOnPage = Float.parseFloat(oldPriceWebElementArray[0]);

        WebElement dateBeginsAtAndEndsAtWebElement = webDriver.findElement(By.xpath("//*[@id=\"app\"]/section[2]/div/div/div[2]/div[2]/div/div[1]/div[2]/p"));
        String[] dateBeginsAtAndEndsAtWebElementArray = dateBeginsAtAndEndsAtWebElement.getText().split(" ");
        String dateBeginsAtOnPages = dateBeginsAtAndEndsAtWebElementArray[1] + " " + dateBeginsAtAndEndsAtWebElementArray[2];
        String dateEndsAtOnPages = dateBeginsAtAndEndsAtWebElementArray[4] + " " + dateBeginsAtAndEndsAtWebElementArray[5];

        Calendar calendar = Calendar.getInstance();

        if(priceResp == priceOnPage){

        }else{ log.error("Валидация цены не верная"); }

        if(productPaperCatalogResp.equals(productPaperCatalogOnPages)){

        }else{log.error("Валидация названия продукта бумажного каталога не верная");}

        if(paperCatalogResp.equals(paperCatalogWebElement.getText())){

        }else{log.error("Валидация названия бумажного каталога не верная");}

        if(discontResp == discontOnPages){

        }else{log.error("Валидация скидки не верная");}

        if(oldPriceResp == oldPriceOnPage){

        }else{log.error("Валидация старой цены не верная");}

        if(dateBeginsAtResp.equals(dateBeginsAtOnPages)){

        }else{log.error("Валидация даты начало акции не верная");}

        if(dateEndsAtResp.equals(dateEndsAtOnPages)){

        }else{log.error("Валидация конца акции не верная");}




            isVaidationProductPaperCatalogs = true;




        return isVaidationProductPaperCatalogs;

    }

    public static List<RpcMessage.Message> paperCatalogProductListSetMessage(
            int payloadSetCompanyId,
            int payloadSetPages,
            String payloadsetSort,
            String payloadSetSortDirection,
            String messageSetType) {
        List< RpcMessage.Message > messagesReq = new ArrayList<>();
        RpcMessage.Message messageReq = new RpcMessage.Message();

        RpcPaperCatalogProductListPayload.Payload payloadReq = new RpcPaperCatalogProductListPayload.Payload();

        payloadReq.setCompanyId(payloadSetCompanyId);
        payloadReq.setPage(payloadSetPages);
        payloadReq.setSort(payloadsetSort);
        payloadReq.setSortDirection(payloadSetSortDirection);
        messageReq.setPayload(payloadReq);
        messageReq.setType(messageSetType);

        messagesReq.add(messageReq);

        return messagesReq;
    }
}
