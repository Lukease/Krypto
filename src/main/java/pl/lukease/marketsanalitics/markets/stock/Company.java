package pl.lukease.marketsanalitics.markets.stock;

import pl.lukease.marketsanalitics.markets.Asset;

public class Company extends Asset {
    String name;
    String ticker;
    Double kurs;
    Double change;
    Double changeInProcent;
    Double affectIndex;
    Double shareTrading;
    Double pack;
    Double partInWallet;

    public Company(String name, String ticker, Double kurs, Double change, Double changeInProcent, Double affectIndex, Double shareTrading, Double pack, Double partInWallet) {
        this.name = name;
        this.ticker = ticker;
        this.kurs = kurs;
        this.change = change;
        this.changeInProcent = changeInProcent;
        this.affectIndex = affectIndex;
        this.shareTrading = shareTrading;
        this.pack = pack;
        this.partInWallet = partInWallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
       this.ticker = ticker;
    }

    public Double getKurs() {
        return kurs;
    }

    public void setKurs(Double kurs) {
        this.kurs = kurs;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getChangeInProcent() {
        return changeInProcent;
    }

    public void setChangeInProcent(Double changeInProcent) {
        this.changeInProcent = changeInProcent;
    }

    public Double getAffectIndex() {
        return affectIndex;
    }

    public void setAffectIndex(Double affectIndex) {
        this.affectIndex = affectIndex;
    }

    public Double getShareTrading() {
        return shareTrading;
    }

    public void setShareTrading(Double shareTrading) {
        this.shareTrading = shareTrading;
    }

    public Double getPack() {
        return pack;
    }

    public void setPack(Double pack) {
        this.pack = pack;
    }

    public Double getPartInWallet() {
        return partInWallet;
    }

    public void setPartInWallet(Double partInWallet) {
        this.partInWallet = partInWallet;
    }
}
