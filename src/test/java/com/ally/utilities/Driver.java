package com.ally.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Driver {


    private Driver() {
    }



    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {
        String browserName = ConfigReader.read("browser");


        if (driverPool.get() == null) {
            switch (browserName.toLowerCase()) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    break;

                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().window().maximize();
                    break;

//                default:
//                    System.out.println("Unknown browser type " + browserName);


            }
            return driverPool.get();
        }else {
            return driverPool.get();
        }


    }



    public static void closeBrowser() {

        // check if we have WebDriver instance or not
        // basically checking if obj is null or not
        // if not null
        // quit the browser
        // make it null , cz once quit it can not be used;

        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.set(null); // so when ask it again , it gives us not quited fresh driver
        }
    }


}