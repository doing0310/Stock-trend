package com.doing.stocktrend.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Stock2 {
    /**
     * @author doing
     */
    private String stockCode;
    private String stockName;
    private String rise;
    private String marketId;
    private String price;
    private String priceRise;
    private String inflow;
    private String inflowOrigin;
    private String shareHolding;
    private double shareHoldingOrigin;
    private String radio;

    public Stock2() {
    }

    public Stock2(String stockCode, String stockName, String rise, String marketId, String price, String priceRise, String inflow, String inflowOrigin, String shareHolding, double shareHoldingOrigin, String radio) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.rise = rise;
        this.marketId = marketId;
        this.price = price;
        this.priceRise = priceRise;
        this.inflow = inflow;
        this.inflowOrigin = inflowOrigin;
        this.shareHolding = shareHolding;
        this.shareHoldingOrigin = shareHoldingOrigin;
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Stock2{" +
                "stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                ", rise='" + rise + '\'' +
                ", marketId='" + marketId + '\'' +
                ", price='" + price + '\'' +
                ", priceRise='" + priceRise + '\'' +
                ", inflow='" + inflow + '\'' +
                ", inflowOrigin='" + inflowOrigin + '\'' +
                ", shareHolding='" + shareHolding + '\'' +
                ", shareHoldingOrigin=" + shareHoldingOrigin +
                ", radio='" + radio + '\'' +
                '}';
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }
    public String getStockCode() {
        return stockCode;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }
    public String getStockName() {
        return stockName;
    }

    public void setRise(String rise) {
        this.rise = rise;
    }
    public String getRise() {
        return rise;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }
    public String getMarketId() {
        return marketId;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getPrice() {
        return price;
    }

    public void setPriceRise(String priceRise) {
        this.priceRise = priceRise;
    }
    public String getPriceRise() {
        return priceRise;
    }

    public void setInflow(String inflow) {
        this.inflow = inflow;
    }
    public String getInflow() {
        return inflow;
    }

    public void setInflowOrigin(String inflowOrigin) {
        this.inflowOrigin = inflowOrigin;
    }
    public String getInflowOrigin() {
        return inflowOrigin;
    }

    public void setShareHolding(String shareHolding) {
        String unit = shareHolding.substring(shareHolding.length()-1,shareHolding.length());
        if("亿".equals(unit)){
            Double count = Double.valueOf(shareHolding.substring(0,shareHolding.length()-1))*100000000;
            shareHolding = Double.toString(count);
        }
        if("万".equals(unit)){
            Double count = Double.valueOf(shareHolding.substring(0,shareHolding.length()-1))*10000;
            shareHolding = Double.toString(count);
        }
        this.shareHolding = shareHolding;
    }
    public String getShareHolding() {
        return shareHolding;
    }

    public void setShareHoldingOrigin(double shareHoldingOrigin) {
        this.shareHoldingOrigin = shareHoldingOrigin;
    }
    public double getShareHoldingOrigin() {
        return shareHoldingOrigin;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }
    public String getRadio() {
        return radio;
    }

}