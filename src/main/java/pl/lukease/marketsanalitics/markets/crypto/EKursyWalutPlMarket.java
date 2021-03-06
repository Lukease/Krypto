package pl.lukease.marketsanalitics.markets.crypto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.lukease.marketsanalitics.markets.Asset;
import pl.lukease.marketsanalitics.markets.Market;


import java.util.List;

public class EKursyWalutPlMarket extends Market {

    public EKursyWalutPlMarket() {
        super("EKursyWalutPl", "https://e-kursy-walut.pl/");
    }

    @Override
    public void getAllAssetInfo(WebDriver driver) {
        driver.get("https://e-kursy-walut.pl/");
        List<WebElement> table = driver.findElements(By.xpath("//table[@data-id='crypto']/tbody/tr"));
        String marketName = "EKursyWalutPl";
        List<WebElement> attribute = table.get(0).findElements(By.tagName("td"));
        for (int i = 0; i < table.size(); i++) {
            String name = table.get(i).findElement(By.tagName("span")).getText().split(" ")[0];
            Double price = Double.parseDouble(table.get(i).findElement(By.className("price")).getText().split("\n")[0].replace(" ", "").replace("PLN", ""));
            Double wolumen = Double.parseDouble(attribute.get(4).getText().split(" ")[0]);
            Double priceChange = Double.parseDouble(attribute.get(2).getText().split("%")[0]);

            assetList.add(new Asset(name, price, priceChange, wolumen, marketName));
        }
    }

    @Override
    public void getMaxMinPriceAsset(WebDriver driver, String assetName) {
    }
}
