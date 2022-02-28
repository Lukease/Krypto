package pl.lukease.crypto;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.lukease.crypto.markets.BinanceMarket;
import pl.lukease.crypto.markets.EKursyWalutPlMarket;
import pl.lukease.crypto.markets.Market;
import pl.lukease.crypto.markets.ZondaMarket;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

        List<Market> marketList = new ArrayList<>();
        marketList.add(new ZondaMarket());
        marketList.add(new BinanceMarket());
        marketList.add(new EKursyWalutPlMarket());

        marketList.forEach(market -> market.getAllCryptoInfo(driver));
        cryptoUtils = new CryptoUtils(driver);
        marketList.forEach(market -> market.getCryptoList().forEach(
               crypto -> market.getMaxMinPriceCrypto(driver, crypto.getName())));
        //driver.quit();
    }
}