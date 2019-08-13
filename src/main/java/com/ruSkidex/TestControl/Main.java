package com.ruSkidex.TestControl;


import com.ruSkidex.TestGo.Delivery.Leding.*;
import com.ruSkidex.TestGo.SkidexSite.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.ruSkidex.Config.Сonfiguration.IS_DEPOY_OK;
import static com.ruSkidex.TestControl.DriverMain.webDriver;


public class Main {


    public static WebElement findElement (String Xpath){

        WebElement element = webDriver.findElement(By.xpath(Xpath));

        return element;
    }



     static Class[] classesTestsSkidexSite =  new Class[] {RegistrationTest.class,
             LoginTest.class,
             PasswordRecoveryTest.class,
             SearchMapTest.class,
             CityCheckTest.class,
             SearchTest.class,
             SearchCensorshipTest.class,
             OpenPaperCatalogTest.class,
             CheckingPossibilityPurchaseTest.class};

    static Class[] classesTestsDelivery = new Class[] {
            AddProductToOrderTest.class,
            CheckCategorySelectionTest.class,
            CheckHomePageValidationTest.class,
            CheckingAddressOnMainVellageTest.class,
            CheckingValidityInformationInContactsTest.class,
            CheckoutTest.class


    };


    @BeforeSuite
    public  void start() {
        DriverMain driverMain = new DriverMain();
        driverMain.doDriver();

    }
    @AfterSuite
    public void stop () {

        webDriver.quit();
    }

    public static void main(String[] args) {
        TestNG testng = new TestNG();

        testng.setTestClasses(classesTestsDelivery);
        testng.run();

                if(IS_DEPOY_OK){
            System.exit(0);
        }else{
            System.exit(121);
        }

    }
}
