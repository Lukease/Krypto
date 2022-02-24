package pl.lukease.crypto;

import java.util.Objects;

public class Crypto {
    String name;
    Double price;
    Double priceChange;
    Double wolumen;
    String marketName;

    public Crypto(String name, Double price, Double priceChange, Double wolumen, String marketName) {
        this.name = name;
        this.price = price;
        this.priceChange = priceChange;
        this.wolumen = wolumen;
        this.marketName = marketName;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(Double priceChange) {
        this.priceChange = priceChange;
    }

    public Double getWolumen() {
        return wolumen;
    }

    public void setWolumen(Double wolumen) {
        this.wolumen = wolumen;
    }
}
