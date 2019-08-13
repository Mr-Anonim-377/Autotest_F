package com.ruSkidex.ScenariosTests;

import com.ruSkidex.HelperClasses.Expectation;
import com.ruSkidex.TestControl.DriverMain;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.ruSkidex.Config.Сonfiguration.*;
import static com.ruSkidex.TestControl.DriverMain.webDriver;


public class Login {
    public boolean personalData;

    String username = "";

    public void scenarioLoginClient (String username,String pass) {
        webDriver.get(ADRESS);
        Expectation.wait(1000);
        goPopup();
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div/form[1]/div[2]/input[1]")).sendKeys(username);
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div/form[1]/div[2]/input[2]")).sendKeys(pass);
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div/form[1]/div[3]/button")).click();
        Expectation.wait(1000);
        goPopup();
        webDriver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[3]/div[1]/div/div[1]/ul/li[2]/a/p[1]")).click();
        this.username = username;
        personalData = accessCheck(this.username);
    }
    public void goPopup(){
        Actions builder = new Actions(webDriver);
        builder.moveToElement(webDriver.findElement(By.xpath(LOGIN_ICON_INSTANCE_OTHER))).build().perform();
        builder.moveToElement(webDriver.findElement(By.xpath(LOGIN_ICON_INSTANCE))).build().perform();
    }
    public boolean accessCheck(String username){
        boolean isAccesCheck = false;
        String userLogin = webDriver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/main/div[1]/h3")).getText();
        String[] userLoginWord = userLogin.split(" ");
        for(String i:userLoginWord){
            if(i.equals(username)){
                isAccesCheck = true;
            }
        }
        return isAccesCheck;
    }
}
