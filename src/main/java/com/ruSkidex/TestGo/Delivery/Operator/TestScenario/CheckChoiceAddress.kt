package com.ruSkidex.TestGo.Delivery.Operator.TestScenario

import org.apache.log4j.Logger
import com.ruSkidex.TestControl.DriverMain.webDriver
import com.ruSkidex.TestControl.Main.findElement
import org.openqa.selenium.By

class CheckChoiceAddress {

    private var isCheckChoiceAddress : Boolean = false
    val checkValidationOfOrdersList : CheckValidationOfOrdersList = CheckValidationOfOrdersList()

    fun scenarioCheckChoiceAddress(testClass: Class<out Any>) : Boolean {
        var log = Logger.getLogger(testClass)

        checkValidationOfOrdersList.scenarioCheckValidationOfOrdersList(testClass)
        log.info("Прошла проверка валидации списка заказов ")




        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/table/tbody/tr[2]/td[4]/a")).click() // переход в заказ


        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/a[1]")).click() // Выбор адрессов



        findElement("Burger King").sendKeys("Россия, Москва, улица Ленинская Слобода, 19")


        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/table/tbody/tr[2]/td[2]/button")).click() // кнопка выбрать адресс ( первая )

        val adress = findElement("//*[@id=\"app\"]/div/input").text.trim()


        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/ol/li[2]/a")).click()  // перейти в заказ



        val adressOnOrder = findElement("//*[@id=\"app\"]/div/div/div/dl[2]/dd").text.trim() // уточненный адресс


        isCheckChoiceAddress = adress == adressOnOrder


        return isCheckChoiceAddress
    }

}
