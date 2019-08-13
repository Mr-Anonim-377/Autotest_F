package com.ruSkidex.TestGo.Delivery.Operator

import com.ruSkidex.HelperClasses.TestCase
import com.ruSkidex.TestControl.Main
import com.ruSkidex.TestGo.Delivery.Leding.CheckCategorySelectionTest
import com.ruSkidex.TestGo.Delivery.Operator.TestScenario.CheckValidationOfOrdersList
import org.testng.annotations.Test
import java.io.IOException

class CheckValidationOfOrdersListTest : Main() {


    var testCase : TestCase = TestCase()
    var checkValidationOfOrdersList : CheckValidationOfOrdersList = CheckValidationOfOrdersList()

    @Test
    @Throws(IOException::class)
    fun test (){

         testCase.testCase("проверка выбора категорий",
                checkValidationOfOrdersList.scenarioCheckValidationOfOrdersList(CheckCategorySelectionTest::class.java),
                checkValidationOfOrdersList.toString(),
                CheckCategorySelectionTest::class.java)

    }



}
