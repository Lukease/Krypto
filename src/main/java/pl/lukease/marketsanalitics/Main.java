package pl.lukease.marketsanalitics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pl.lukease.marketsanalitics.markets.crypto.BinanceMarket;
import pl.lukease.marketsanalitics.markets.crypto.EKursyWalutPlMarket;
import pl.lukease.marketsanalitics.markets.crypto.ZondaMarket;
import pl.lukease.marketsanalitics.markets.stock.BankierMarket;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static WebDriver driver;
    static AssetUtils assetUtils;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        List<pl.lukease.marketsanalitics.markets.Market> marketList = new ArrayList<>();
        marketList.add(new ZondaMarket());
        marketList.add(new BinanceMarket());
        marketList.add(new EKursyWalutPlMarket());
        marketList.add(new BankierMarket());



        marketList.forEach(market -> market.getAllAssetInfo(driver));
        assetUtils = new AssetUtils(driver);
        marketList.forEach(market -> market.getAssetList().forEach(
               asset -> market.getMaxMinPriceAsset(driver, asset.getName())));


        //driver.quit();
    }
}