package pl.lukease.crypto.markets;

import org.openqa.selenium.WebDriver;
import pl.lukease.crypto.Crypto;
import pl.lukease.crypto.exception.CryptoNotFoundException;


import java.util.ArrayList;
import java.util.List;

public abstract class Market {
    private String name;
    private String urlAddress;
    List<Crypto> cryptoList = new ArrayList<>();

    public Market(String name, String urlAddress) {
        this.name = name;
        this.urlAddress = urlAddress;
    }

    public List<Crypto> getCryptoList() {
        return cryptoList;
    }

    public abstract void getAllCryptoInfo(WebDriver driver);

    public abstract void getMaxMinPriceCrypto(WebDriver driver, String cryptoName);

    public Crypto getCryptoByName(String cryptoName) {
        return cryptoList.stream().filter(crypto -> crypto.getName().equals(cryptoName)).findFirst().orElseThrow(CryptoNotFoundException::new);

    }
}
