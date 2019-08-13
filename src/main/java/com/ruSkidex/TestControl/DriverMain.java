package com.ruSkidex.TestControl;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.security.auth.login.Configuration;
import java.security.Security;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static com.ruSkidex.Config.Сonfiguration.*;

public class DriverMain {

    public static WebDriver driver;
    public ChromeOptions options = new ChromeOptions();
    public String driverPath;
    private static final Logger log = Logger.getLogger(DriverMain.class);
    public static WebDriver webDriver;

    public void doDriver()  {



        addOptions();
        certainSystems();

        System.setProperty("webdriver.chrome.driver", driverPath);
        //System.setProperty("webdriver.chrome.logfile", DRIVER_PATH);
//        System.setProperty ("webdriver.chrome.verboseLogging", "true");
//        System.setProperty("webdriver.chrome.args", "--enable-logging");
        //System.setProperty("webdriver.chrome.silentOutput", "true");
//        System.setProperty("webdriver-manager start","4444");

//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
//        driver = new ChromeDriver(capabilities);











        driver = new ChromeDriver(options);
        webDriver = driver;

        log.info("Драйвер загружен успещно");

        driverManager();
    }

    private void addOptions() {
//        options.setCapability("ACCEPT_SSL_CERTS", true);
        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--headless");
        options.addArguments("--verbose");
//        options.addArguments("window-size=1500x1500");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        //options.setHeadless(true);
//        options.setCapability("browserName","chrome");
//        options.setCapability("platform","LINUX");
//        options.setCapability("acceptSslCerts", true);



    }

    private void driverManager() {
        webDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        webDriver.manage().window().setSize(new Dimension(1500, 1500));
    }

    private void certainSystems() {
        String[] systemArray = System.getProperty("os.name").split(" ");
        if (systemArray[0].contains("Windows")) {
            driverPath = SUSTEM_REP + DRIVER_WiNDOWS;
        } else {
            driverPath = SUSTEM_REP + DRIVER_UNIX;
        }
    }
}
