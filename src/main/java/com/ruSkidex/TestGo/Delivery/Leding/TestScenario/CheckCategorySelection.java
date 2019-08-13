package com.ruSkidex.TestGo.Delivery.Leding.TestScenario;

import com.google.gson.Gson;
import com.ruSkidex.HelperClasses.Expectation;
import com.ruSkidex.RestMethod.Gson.Reqest.RpcDeliveryLandingCategoriesSnippetsPayload;
import com.ruSkidex.RestMethod.Gson.Reqest.RpcDeliveryLandingProductsPayload;
import com.ruSkidex.RestMethod.Gson.Reqest.RpcMessage;
import com.ruSkidex.RestMethod.Gson.RpcDeliveryLandingCategoriesSnippetsGson;
import com.ruSkidex.RestMethod.Gson.RpcDeliveryLandingProductsGson;
import com.ruSkidex.RestMethod.HTTPMethodRpc;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.List;

import static com.ruSkidex.Config.Сonfiguration.ADRESS_LEDING;
import static com.ruSkidex.TestControl.DriverMain.webDriver;
import static com.ruSkidex.TestGo.Delivery.Leding.TestScenario.CheckHomePageValidation.reqestSetMessage;

public class CheckCategorySelection {
    private boolean isCheckCategorySelection;
    private boolean isCategoriiValid;
    private boolean isProductInCategoryValid;


    private RpcMessage reqest = new RpcMessage();
    private String rpcJsonReq;
    private Gson g = new Gson();
    private RpcDeliveryLandingCategoriesSnippetsPayload.Payload rpcDeliveryLandingCategoriesSnippetsPayload = new RpcDeliveryLandingCategoriesSnippetsPayload.Payload();



    public boolean scenarioCheckCategorySelection( Class testClass){




        Logger log = Logger.getLogger(testClass);

        webDriver.get(ADRESS_LEDING);
        log.info("Загрулизась страница лединга");

        String [] linkRestArray = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/a")).getAttribute("href").split("/");

        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/a")).click();
        log.info("Переход в кафе");

        int companId = Integer.valueOf(linkRestArray[linkRestArray.length -1]);


        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[3]/div[1]/div[1]")).click(); // категории
        log.info("Переход в категории");
        Expectation.wait(200);

        String categoria = webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[3]/div[1]/div[1]/div[2]/span[1]")).getText(); // категория в pop up


        webDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[3]/div[1]/div[1]/div[2]/span[1]")).click(); // категория в pop up
        log.info("переход по категории");



        reqest.setMessages(reqestSetMessage("deliveryLandingCategoriesSnippets"));
        rpcDeliveryLandingCategoriesSnippetsPayload.setCompanyId(Integer.valueOf(companId));
        reqest.getMessages().get(0).setPayload(rpcDeliveryLandingCategoriesSnippetsPayload);


        rpcJsonReq = g.toJson(reqest);
        HTTPMethodRpc htttpRpc = new HTTPMethodRpc();


        String answerDeliveryLandingCategoriesSnippets = htttpRpc.getRpcMethodAnswer(rpcJsonReq);
        log.info("Отправлен запрос deliveryLandingCategoriesSnippets");

        RpcDeliveryLandingCategoriesSnippetsGson.DeliveryLandingCategoriesSnippets rpcDeliveryLandingCategoriesSnippetsGson = g.fromJson(answerDeliveryLandingCategoriesSnippets,  RpcDeliveryLandingCategoriesSnippetsGson.DeliveryLandingCategoriesSnippets.class);


        List<RpcDeliveryLandingCategoriesSnippetsGson.Message> messages = rpcDeliveryLandingCategoriesSnippetsGson.getMessages();
        RpcDeliveryLandingCategoriesSnippetsGson.Message message = messages.get(0);
        RpcDeliveryLandingCategoriesSnippetsGson.Payload payload = message.getPayload();
        List<RpcDeliveryLandingCategoriesSnippetsGson.Category> categories = payload.getCategories();
        RpcDeliveryLandingCategoriesSnippetsGson.Category category = categories.get(0);
        int categoryId = category.getId();
        String title = category.getTitle();

        log.info("Получен ответ от запроса deliveryLandingCategoriesSnippets");

        isCategoriiValid = categoria.equals(title);



        reqest.setMessages(reqestSetMessage("deliveryLandingProducts"));
        RpcDeliveryLandingProductsPayload.Payload rpcDeliveryLandingProductsPayload = new RpcDeliveryLandingProductsPayload.Payload();
        rpcDeliveryLandingProductsPayload.setPage(1);
        rpcDeliveryLandingProductsPayload.setCompanyId(companId);
        rpcDeliveryLandingProductsPayload.setCategoryId(categoryId);
        reqest.getMessages().get((0)).setPayload(rpcDeliveryLandingProductsPayload);

        rpcJsonReq = g.toJson(reqest);



        String answerDeliveryLandingProducts = htttpRpc.getRpcMethodAnswer(rpcJsonReq);
        log.info("Отправлен запрос deliveryLandingProducts");


        RpcDeliveryLandingProductsGson.DeliveryLandingProducts deliveryLandingProducts = g.fromJson(answerDeliveryLandingProducts,  RpcDeliveryLandingProductsGson.DeliveryLandingProducts.class);

        List<RpcDeliveryLandingProductsGson.Message> productMessages = deliveryLandingProducts.getMessages();
        RpcDeliveryLandingProductsGson.Message productMessage = productMessages.get(0);
        RpcDeliveryLandingProductsGson.Payload productPayload = productMessage.getPayload();
        List<RpcDeliveryLandingProductsGson.Product> products = productPayload.getProducts();
        log.info("Получен ответ от запроса deliveryLandingProducts");

        int countingDiv = 1;

        for(RpcDeliveryLandingProductsGson.Product i : products){


               isProductInCategoryValid  = i.getTitle().contains(webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div["+countingDiv+"]/div/div[1]/div[2]")).getText());
            countingDiv ++;

        }
        log.info("Проверена валидация товаров");



        if( isCategoriiValid && isProductInCategoryValid) {

            isCheckCategorySelection = true;
            log.info("Валидация продуктов и категорий верная ");
        }else {

            log.info("Валидация продуктов и категорий не верная ");
        }




        return isCheckCategorySelection;
    }

}
