package pl.lukease.marketsanalitics.markets;

import org.openqa.selenium.WebDriver;
import pl.lukease.marketsanalitics.exception.AssetNotFoundException;


import java.util.ArrayList;
import java.util.List;

public abstract class Market {
    private String name;
    private String urlAddress;
    protected List<Asset> assetList = new ArrayList<>();

    public Market(String name, String urlAddress) {
        this.name = name;
        this.urlAddress = urlAddress;
    }

    public List<Asset> getAssetList() {
        return assetList;
    }

    public abstract void getAllAssetInfo(WebDriver driver);

    public abstract void getMaxMinPriceAsset(WebDriver driver, String assetName);

    public Asset getAssetByName(String assetName) {
        return assetList.stream().filter(asset -> asset.getName().equals(assetName)).findFirst().orElseThrow(AssetNotFoundException::new);
    }

}
