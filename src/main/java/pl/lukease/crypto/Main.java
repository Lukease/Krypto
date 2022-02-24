package pl.lukease.crypto;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {

    static WebDriver driver;
    static CryptoUtils cryptoUtils;


    public void bestPriceTest() {
     //cryptoUtils.getBestPriceToBuy("XRP");
        System.out.println();
    }



    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        cryptoUtils = new CryptoUtils(driver);
        //driver.quit();
    }
}