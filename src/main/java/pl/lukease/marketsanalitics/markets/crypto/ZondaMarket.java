package pl.lukease.marketsanalitics.markets.crypto;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import pl.lukease.marketsanalitics.markets.Asset;
import pl.lukease.marketsanalitics.markets.Market;

import java.time.Duration;
import java.util.List;

public class ZondaMarket extends Market {
    public ZondaMarket() {
        super("Zonda", "https://zondaglobal.com/pl/kurs-walut");
    }

    @Override
    public void getAllAssetInfo(WebDriver driver) {
        driver.get("https://zondaglobal.com/pl/kurs-walut");
        List<WebElement> table = driver.findElements(By.className("visible"));
        String marketName = "Zonda";
        for (int i = 0; i < table.size(); i++) {
            List<WebElement> attribute = table.get(i).findElements(By.tagName("td"));
            String name = attribute.get(0).getText().split("[(-)]")[1];
            Double price = Double.parseDouble(attribute.get(2).getText().split(" ")[0].replace(",", ""));
            Double wolumen = Double.parseDouble(attribute.get(3).getText().split(" ")[0].replace(",", ""));
            Double priceChange = Double.parseDouble(attribute.get(4).getText().split("%")[0]);

            assetList.add(new Asset(name, price, priceChange, wolumen, marketName));
        }
    }

    @Override
    public void getMaxMinPriceAsset(WebDriver driver, String assetName) {
        driver.get("https://zondaglobal.com/pl/kurs-walut");
        WebElement cookies = driver.findElement(By.id("cookie-bar__accept-button"));
        if (cookies.isDisplayed()) {
            cookies.click();
        }
        driver.findElement(By.className("zonda-search")).click();
        driver.findElement(By.xpath("//div[@class='zonda-search']/input")).sendKeys(assetName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement button = driver.findElement(By.className("zonda-cell-btn-wrapper"));
            wait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
        } catch (StaleElementReferenceException e) {
            WebElement button = driver.findElement(By.className("zonda-cell-btn-wrapper"));
            wait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
        }

        Double maxPrice = Double.parseDouble(driver.findElement(By.xpath("//div[@id='currency-market-figure']/div/div[2]/div[1]/div[1]/span")).getText().replace(",", "").replace(" PLN", ""));
        Double minPrice = Double.parseDouble(driver.findElement(By.xpath("//div[@id='currency-market-figure']/div/div[2]/div[1]/div[2]/span")).getText().replace(",", "").replace(" PLN", ""));

        Asset assetData = getAssetByName(assetName);
        assetData.setMaxPriceToday(maxPrice);
        assetData.setMinPriceToday(minPrice);

        System.out.println("Najwyższa cena 24h " + assetName + ":" + maxPrice);
        System.out.println("Najniższa cena 24h " + assetName + ":" + minPrice);
    }

}