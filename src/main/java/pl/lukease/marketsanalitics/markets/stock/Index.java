package pl.lukease.marketsanalitics.markets.stock;

import pl.lukease.marketsanalitics.markets.Asset;

import java.util.ArrayList;
import java.util.List;

public class Index extends Asset{
    String name;
    Double rate;
    Double change;
    Double changeInProcent;
    Double open;
    Double max;
    Double min;
    Double turnOver;
    List<CompanyInIndex> companiesInIndex = new ArrayList<>();

    public Index(String name, Double rate, Double change, Double changeInProcent, Double open, Double max, Double min, Double turnOver) {
        this.name = name;
        this.rate = rate;
        this.change = change;
        this.changeInProcent = changeInProcent;
        this.open = open;
        this.max = max;
        this.min = min;
        this.turnOver = turnOver;
    }

    public void getAllCompaniesInIndex(){
        companiesInIndex.add(new CompanyInIndex());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
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

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(Double turnOver) {
        this.turnOver = turnOver;
    }
}
