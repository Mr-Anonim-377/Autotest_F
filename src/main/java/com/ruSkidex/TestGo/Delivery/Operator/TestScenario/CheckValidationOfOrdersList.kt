package com.ruSkidex.TestGo.Delivery.Operator.TestScenario

import com.google.gson.Gson
import com.ruSkidex.RestMethod.Gson.Reqest.RpcMessage
import com.ruSkidex.RestMethod.Gson.Reqest.RpcOperatorDeliveryRequestListPayload
import com.ruSkidex.RestMethod.Gson.RpcOperatorDeliveryRequestListGson
import com.ruSkidex.RestMethod.HTTPMethodRpc
import com.ruSkidex.TestControl.DriverMain.webDriver
import com.ruSkidex.TestControl.Main
import com.ruSkidex.TestControl.Main.findElement
import com.ruSkidex.TestGo.Delivery.Leding.CheckCategorySelectionTest
import com.ruSkidex.TestGo.Delivery.Leding.TestScenario.CheckHomePageValidation.reqestSetMessage
import org.apache.log4j.Logger
import org.openqa.selenium.By
import java.lang.Exception

class CheckValidationOfOrdersList {

    private var isValidation : Boolean = false
    private var isCheckValidationOfOrdersListTest : Boolean = false
    private var reqest = RpcMessage()
    private var rpcDeliveryLandingCategoriesSnippetsPayload : RpcOperatorDeliveryRequestListPayload.Payload =RpcOperatorDeliveryRequestListPayload.Payload()
    private var rpcJsonReq: String? = null
    private var g = Gson()


    fun scenarioCheckValidationOfOrdersList(testClass: Class<out Any>) : Boolean {

        var log = Logger.getLogger(testClass)

        webDriver.get("https://t-delivery-operator.skidex.ru")
        log.info("Загрулизась страница лединга")


        webDriver.findElement(By.xpath("//*[@id=\"inputEmail\"]")).sendKeys("operator")
        webDriver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("zu0#8VLH")
        webDriver.findElement(By.xpath("//*[@id=\"loginform\"]/button")).click()


        findElement("/html/body/div[1]/p/a").click()


        reqest.messages = reqestSetMessage("operatorDeliveryRequestList")

        rpcDeliveryLandingCategoriesSnippetsPayload.page = 1

        reqest.messages.firstOrNull()?.payload = rpcDeliveryLandingCategoriesSnippetsPayload

        rpcJsonReq = g.toJson(reqest)
        val htttpRpc = HTTPMethodRpc()




        val answerRpcOperatorDeliveryRequestList : String  = htttpRpc.getRpcMethodAnswer(rpcJsonReq)

        log.info("Отправлен запрос operatorDeliveryRequestList")

        var rpcOperatorDeliveryRequestListGson : RpcOperatorDeliveryRequestListGson.OperatorDeliveryRequestList = g.fromJson(answerRpcOperatorDeliveryRequestList,RpcOperatorDeliveryRequestListGson.OperatorDeliveryRequestList::class.java)


        val items = rpcOperatorDeliveryRequestListGson.messages.get(0).payload.items

        var idPageTr : Int = 2
        var createDatePagesTr : Int = 2
        var updateDatePagesTr : Int = 2


        for(i:RpcOperatorDeliveryRequestListGson.Item in items){




            var id : Int = i.deliveryRequest.id
            var createDate : List<String> =  i.deliveryRequest.createdAt.split(" ")
            var updateDate : List<String> = i.deliveryRequest.updatedAt.split(" ")


            var idPage : String  = findElement("//*[@id=\"app\"]/div/div/table/tbody/tr[${idPageTr}]/th").text

            var createDatePages : List<String> = findElement("//*[@id=\"app\"]/div/div/table/tbody/tr[${createDatePagesTr}]/td[1]").text.split(" ")

            var updateDatePages : List<String> = findElement("//*[@id=\"app\"]/div/div/table/tbody/tr[${updateDatePagesTr}]/td[2]").text.split(" ")






            isValidation = idPage == id.toString()
                    && createDate[0].contains(createDatePages[0]) && updateDate[0].contains(updateDatePages[0])
                    && createDate[1].contains(createDatePages[1]) && updateDate[1].contains(updateDatePages[1])

        try {
            if (!isValidation) {

                throw Exception("idPage = ${idPage}; id = ${id}; " +
                        "createDate = ${createDate[0] + createDate[1]}; createDatePages = ${createDatePages[0] + createDatePages[1]};" +
                        "updateDate = ${updateDate[0] + updateDate[1]}; updateDatePages = ${updateDatePages[0] + updateDatePages[1]}")
            }
        }catch (e : Exception){

        }

            idPageTr++
            createDatePagesTr++
            updateDatePagesTr++
        }




        isCheckValidationOfOrdersListTest = isValidation






        return isCheckValidationOfOrdersListTest
    }


    private operator fun Int.invoke(i: Int) {

    }
}





