package pl.lukease.marketsanalitics.markets;


public class Asset {
   private String name;
   private Double price;
   private Double priceChange;
   private Double wolumen;
   private String marketName;
   private Double maxPriceToday;
   private Double minPriceToday;

    public Asset(String name, Double price, Double priceChange, Double wolumen, String marketName) {
        this.name = name;
        this.price = price;
        this.priceChange = priceChange;
        this.wolumen = wolumen;
        this.marketName = marketName;
    }

    public Asset() {
    }

    public Double getMaxPriceToday() {
        return maxPriceToday;
    }

    public void setMaxPriceToday(Double maxPriceToday) {
        this.maxPriceToday = maxPriceToday;
    }

    public Double getMinPriceToday() {
        return minPriceToday;
    }

    public void setMinPriceToday(Double minPriceToday) {
        this.minPriceToday = minPriceToday;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
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
