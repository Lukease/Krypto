package pl.lukease.crypto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class CryptoUtils {

    private final JavascriptExecutor jse;
    List<Crypto> binanceCrypto = new ArrayList<>();
    List<Crypto> eKursyWalutPlCrypto = new ArrayList<>();
    List<Crypto> zondaCrypto = new ArrayList<>();
    WebDriver driver;

    public void getCryptoZondaInformation() {
        driver.get("https://zondaglobal.com/pl/kurs-walut");
        List<WebElement> table = driver.findElements(By.className("visible"));
        String marketName = "Zonda";
        for (int i = 0; i < table.size(); i++) {
            List<WebElement> attribute = table.get(i).findElements(By.tagName("td"));
            String name = attribute.get(0).getText().split("[(-)]")[1];
            Double price = Double.parseDouble(attribute.get(2).getText().split(" ")[0].replace(",", ""));
            Double wolumen = Double.parseDouble(attribute.get(3).getText().split(" ")[0].replace(",", ""));
            Double priceChange = Double.parseDouble(attribute.get(4).getText().split("%")[0]);

            zondaCrypto.add(new Crypto(name, price, priceChange, wolumen, marketName));
        }
        System.out.println(zondaCrypto);
    }

    public void getCryptoBinanceInformation() {
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

            binanceCrypto.add(new Crypto(name, price, priceChange, wolumen, marketName));
        }
        System.out.println(binanceCrypto);
    }

    public void getEKursyWalutPlInformation() {
        driver.get("https://e-kursy-walut.pl/");
        List<WebElement> table = driver.findElements(By.xpath("//table[@data-id='crypto']/tbody/tr"));
        String marketName = "EKursyWalutPl";
        List<WebElement> attribute = table.get(0).findElements(By.tagName("td"));
        for (int i = 0; i < table.size(); i++) {
            String name = table.get(i).findElement(By.tagName("span")).getText().split(" ")[0];
            Double price = Double.parseDouble(table.get(i).findElement(By.className("price")).getText().split("\n")[0].replace(" ", "").replace("PLN", ""));
            Double wolumen = Double.parseDouble(attribute.get(4).getText().split(" ")[0]);
            Double priceChange = Double.parseDouble(attribute.get(2).getText().split("%")[0]);

            eKursyWalutPlCrypto.add(new Crypto(name, price, priceChange, wolumen, marketName));
        }
        System.out.println(eKursyWalutPlCrypto);
    }



    public CryptoUtils(WebDriver driver) {
        this.driver = driver;
        this.jse = (JavascriptExecutor) driver;

    }
}

