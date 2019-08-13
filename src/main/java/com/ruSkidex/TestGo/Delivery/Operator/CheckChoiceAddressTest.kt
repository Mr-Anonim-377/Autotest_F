package com.ruSkidex.TestGo.Delivery.Operator

import com.ruSkidex.HelperClasses.TestCase
import com.ruSkidex.TestControl.Main
import com.ruSkidex.TestGo.Delivery.Operator.TestScenario.CheckChoiceAddress
import org.testng.annotations.Test
import java.io.IOException

class CheckChoiceAddressTest : Main(){
    var testCase : TestCase = TestCase()
    private var checkChoiceAddress : CheckChoiceAddress = CheckChoiceAddress()

    @Test
    @Throws(IOException::class)
    fun test (){
        testCase.testCase("проверка выбора категорий",
                checkChoiceAddress.scenarioCheckChoiceAddress(CheckChoiceAddressTest::class.java),
                checkChoiceAddress.toString(),
                CheckChoiceAddressTest::class.java)
    }


    }