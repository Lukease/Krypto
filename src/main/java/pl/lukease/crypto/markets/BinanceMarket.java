package pl.lukease.crypto.markets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.lukease.crypto.Crypto;

import java.util.ArrayList;
import java.util.List;

public class BinanceMarket extends Market {
    public BinanceMarket() {
        super("Binance", "https://www.binance.com/pl/markets");
    }

    @Override
    public void getAllCryptoInfo(WebDriver driver) {

        driver.get("https://www.binance.com/pl/markets");
        List<WebElement> table = driver.findElements(By.className("css-vlibs4"));
        String marketName = "Binance";
        WebElement acceptCookie = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookie.click();
        for (int i = 0; i < table.size(); i++) {
            String name = table.get(i).findElement(By.className("css-1wp9rgv")).getText().split(" ")[0];
            Double price = Double.parseDouble(table.get(i).findElement(By.className("css-ydcgk2")).getText().split("zł")[1].replace(",", ".").replace(" ", ""));
            Double wolumen = Double.parseDouble(table.get(i).findElement(By.className("css-102bt5g")).getText().split("M")[0].replace(",", ".").replace(" ", ""));
            Double priceChange = Double.parseDouble(table.get(i).findElement(By.className("css-18yakpx")).getText().split("%")[0]);

            cryptoList.add(new Crypto(name, price, priceChange, wolumen, marketName));
        }
    }

    @Override
    public void getMaxMinPriceCrypto(WebDriver driver, String cryptoName) {
        driver.get("https://www.binance.com/pl/markets");
        driver.findElement(By.id("markets_main_search")).sendKeys(cryptoName);
        driver.findElement(By.className("css-1mql1kh")).click();
        ArrayList<String> currentTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(currentTabs.get(1));

        List<WebElement> attribute = driver.findElements(By.xpath("//*[@id='__APP']/div/main/section/div/div[2]/div[2]/div[4]/div[2]/div"));
        Double maxPrice = Double.parseDouble(attribute.get(0).getText().split(" ")[2].replace(",", ""));
        Double minPrice = Double.parseDouble(attribute.get(2).getText().split(" ")[2].replace(",", ""));


        System.out.println("Najwyższa cena 24h " + cryptoName + ":" + maxPrice);
        System.out.println("Najniższa cena 24h " + cryptoName + ":" + minPrice);

    }

}
