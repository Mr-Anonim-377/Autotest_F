package com.ruSkidex.TestGo.Delivery.Leding.TestScenario;

import com.google.gson.Gson;
import com.ruSkidex.RestMethod.Gson.DeliveryLandingCompaniesGson;
import com.ruSkidex.RestMethod.Gson.Reqest.RpcMessage;
import com.ruSkidex.RestMethod.HTTPMethodRpc;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.ruSkidex.Config.Сonfiguration.ADRESS_LEDING;
import static com.ruSkidex.TestControl.DriverMain.webDriver;

public class CheckHomePageValidation {


   private boolean isScenarioCheckHomePageValidation = false;
    private RpcMessage reqest = new RpcMessage();
    private String RpcJsonReq;
    private Gson g = new Gson();

    private boolean isBlockOneOk;
    private boolean isBlockTwoOk;
    private boolean isBlockThreeOk;

    public  static List<RpcMessage.Message> reqestSetMessage(String messageSetType) {

        List<RpcMessage.Message> messagesReq = new ArrayList<>();
        RpcMessage.Message messageReq = new RpcMessage.Message();
        messageReq.setType(messageSetType);
        messagesReq.add(messageReq);



        return messagesReq;
    }

    public boolean scenarioCheckHomePageValidation(Class testClass) {
        Logger log = Logger.getLogger(testClass);

        webDriver.get(ADRESS_LEDING);
        log.info("Загрузилась странице лединга");

        WebElement webElementCafeOne = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/a"));
        String cafeOne = webElementCafeOne.getText();

        WebElement elementBlockOneStringOne = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[1]/div[1]/h3"));
        WebElement elementBlockOneStringTwo = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[1]/div[1]/p"));
        WebElement elementImgBlockOne = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[1]/div[2]/img"));
        WebElement elementBlockOne = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[1]"));
        log.info("Найдены элементы инф блока 1 на сглавной станице");




        if(elementBlockOne.isEnabled()&& // Первый блок с инфрмацией
                elementBlockOneStringOne.isEnabled()&& // Текст блока
                elementBlockOneStringTwo.isEnabled()&& // Текст Блока
                elementImgBlockOne.isEnabled()&& // Картинка блока 1
                elementBlockOneStringOne.getText().contains("Доставка за 45 минут")&& // Текст блока
                elementBlockOneStringTwo.getText().contains("Для заказов из кафе и 60 минут для заказов из магазинов") // Текст Блока
         )

        {
            isBlockOneOk = true;
            log.info("Проверен первый блок - все ок");

        } else{
            isBlockOneOk = false;
            log.info("Проверен первый блок - не те данные");

        }


        WebElement elementBlockTwo = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]"));
        WebElement elementBlockTwoStringOne = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]/div[1]/h3"));
        WebElement elementBlockTwoStringTwo = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]/div[1]/p"));
        WebElement elementBlockTwoImg = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[2]/div[2]/img"));
        log.info("Найдены элементы инф блока 2 на сглавной станице");


        if(elementBlockTwo.isEnabled()&&
                elementBlockTwoStringOne.isEnabled()&&
                elementBlockTwoStringTwo.isEnabled()&&
                elementBlockTwoImg.isEnabled()&&
                elementBlockTwoStringOne.getText().contains("Любые продукты и товары из кафе и магазинов")&&
                elementBlockTwoStringTwo.getText().contains("Без наценок, вы расплачиваетесь по чеку из магазина/ресторана")
        )

        {
            log.info("Проверен второй блок - все ок");
            isBlockTwoOk = true;

        }else {

            log.info("Проверен второй блок - не те данные");
            isBlockTwoOk =false;
        }


        WebElement elementBlockThree = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[3]"));
        WebElement elementBlockThreeStringOne = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[3]/div[1]/h3"));
        WebElement elementBlockThreeStringTwo = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[3]/div[1]/p"));
        WebElement elementBlockThreeImg = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div/div[3]/div[2]/img"));
        log.info("Найдены элементы инф блока 3 на сглавной станице");



        if(elementBlockThree.isEnabled()&&
                elementBlockThreeStringOne.isEnabled()&&
                elementBlockThreeStringTwo.isEnabled()&&
                elementBlockThreeImg.isEnabled()&&
                elementBlockThreeStringOne.getText().contains("Бесплатная доставка без минимальной суммы заказа")&&
                elementBlockThreeStringTwo.getText().contains("Доставим вам любой заказ от 1 рубля")
        )
        {
            isBlockThreeOk = true;
            log.info("Проверен третий блок - все ок");
        }else{
            isBlockThreeOk = false;
            log.info("Проверен третий блок - не те данные");

        }







        reqest.setMessages(reqestSetMessage("deliveryLandingCompanies"));

        RpcJsonReq = g.toJson(reqest);
        HTTPMethodRpc htttpRpc = new HTTPMethodRpc();
        String answerDeliveryLandingCompaniesGson = htttpRpc.getRpcMethodAnswer(RpcJsonReq);
        log.info("Отправлен запрос deliveryLandingCompanies");




        DeliveryLandingCompaniesGson.DeliveryLandingCompanies deliveryLandingCompaniesGson = g.fromJson(answerDeliveryLandingCompaniesGson, DeliveryLandingCompaniesGson.DeliveryLandingCompanies.class);

        List<DeliveryLandingCompaniesGson.Message> messages = deliveryLandingCompaniesGson.getMessages();
        DeliveryLandingCompaniesGson.Message message = messages.get(0);
        DeliveryLandingCompaniesGson.Payload payload = message.getPayload();
        List<DeliveryLandingCompaniesGson.Company> companies = payload.getCompanies();
        DeliveryLandingCompaniesGson.Company company = companies.get(0);
        String title = company.getTitle();

        log.info("Получен ответ от запроса deliveryLandingCompanies");


        if(cafeOne.contains(title)&&
                webElementCafeOne.isEnabled()&&
                isBlockOneOk&&
                isBlockTwoOk&&
                isBlockThreeOk
            )

        {
            log.info("Валидный ответ от запроса и верная валидация инф блоков");

            isScenarioCheckHomePageValidation = true;
        } else{
            log.info("Не валидный ответ от запроса и не верная валидация инф блоков");

        }


        return isScenarioCheckHomePageValidation;
    }


}
