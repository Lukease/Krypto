package pl.lukease.marketsanalitics.markets.stock;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BankierMarket extends pl.lukease.marketsanalitics.markets.Market {
    List<Company> companies = new ArrayList<>();
    List<Index> indices = new ArrayList<>();

    public BankierMarket() {
        super("Bankier" , "https://www.bankier.pl/gielda/notowania/indeksy-gpw");
    }

    @Override
    public void getAllAssetInfo(WebDriver driver) {
        driver.get("https://www.bankier.pl/gielda/notowania/indeksy-gpw");
        List<WebElement> table = driver.findElements(By.xpath("//div[@id='boxQuotes']/div[2]/table[1]/tbody"));
        for (int e = 0; e < table.size(); e++) {
            List<WebElement> tableElements = table.get(e).findElements(By.tagName("tr"));
            for (int i = 0; i < tableElements.size(); i++) {
                List<WebElement> attribute = tableElements.get(i).findElements(By.tagName("td"));
                String name = attribute.get(0).getText();
                Double rate = Double.parseDouble(attribute.get(1).getText());
                Double change = Double.parseDouble(attribute.get(2).getText());
                Double changeInProcent = Double.parseDouble(attribute.get(3).getText());
                Double open = Double.parseDouble(attribute.get(4).getText());
                Double max = Double.parseDouble(attribute.get(5).getText());
                Double min = Double.parseDouble(attribute.get(6).getText());
                Double turnOver = Double.parseDouble(attribute.get(7).getText());

                assetList.add(new Index(name, rate, change, changeInProcent, open, max, min, turnOver));
            }
        }
    }

    @Override
    public void getMaxMinPriceAsset(WebDriver driver, String assetName) {
        driver.get("https://www.bankier.pl/inwestowanie/profile/quote.html?symbol=" + assetName);
        List<WebElement> table = driver.findElements(By.xpath("//div[@class='boxTable']/table[1]/tbody/tr"));
        for (int i = 0; i < table.size(); i++) {
            List<WebElement> attribute = table.get(i).findElements(By.tagName("td"));

            String name = attribute.get(0).getText();
            String ticker = attribute.get(1).getText();
            Double kurs = Double.parseDouble(attribute.get(2).getText());
            Double change = Double.parseDouble(attribute.get(3).getText());
            Double changeInProcent = Double.parseDouble(attribute.get(4).getText());
            Double affectIndex = Double.parseDouble(attribute.get(5).getText());
            Double shareTrading = Double.parseDouble(attribute.get(6).getText());
            Double pack = Double.parseDouble(attribute.get(7).getText());
            Double partInWallet = Double.parseDouble(attribute.get(8).getText());

            companies.add(new Company(name, ticker, kurs, change, changeInProcent, affectIndex, shareTrading,pack, partInWallet));
        }


    }
}
