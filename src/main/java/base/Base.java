package base;
import java.util.*;
import java.io.*;

import org.openqa.selenium.WebDriver;

public class Base {
    
  
    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();


    public static void setDriver(WebDriver driver) {
        dr.set(driver);
    }

    public static WebDriver getDriver() {
        return dr.get();
    }

   
    public static void unloadDriver() {
        dr.remove();
    }

    public String getUrl() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\OneDrive - Coforge Limited\\Desktop\\Submission Folder\\Eclipse Workspace\\TestingProject\\src\\main\\java\\data.properties"));
        return prop.getProperty("url");
    }


    public String getBrowser() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\OneDrive - Coforge Limited\\\\Desktop\\\\Submission Folder\\\\Eclipse Workspace\\\\TestingProject\\\\src\\\\main\\\\java\\\\data.properties"));
        return prop.getProperty("browser");
    }
}