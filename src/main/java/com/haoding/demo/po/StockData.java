package com.haoding.demo.po;

import javax.xml.crypto.Data;

public class StockData {

    private Data stock_date;
    private String stock_id;
    private String tock_name;
    private double closing_price_t;
    private double heighst_price;
    private double lowest_price;
    private double opening_price;
    private double closing_price_y;
    private float chang_amount;
    private  float chang_extent;
    private float change_hand_rate;
    private  String turnover_amount;
    private String turnover_money;
    private String total_market_value;
    private String circulation_market_value;

    public StockData(Data stock_date, String stock_id, String tock_name, double closing_price_t, double heighst_price, double lowest_price, double opening_price, double closing_price_y, float chang_amount, float chang_extent, float change_hand_rate, String turnover_amount, String turnover_money, String total_market_value, String circulation_market_value) {
        this.stock_date = stock_date;
        this.stock_id = stock_id;
        this.tock_name = tock_name;
        this.closing_price_t = closing_price_t;
        this.heighst_price = heighst_price;
        this.lowest_price = lowest_price;
        this.opening_price = opening_price;
        this.closing_price_y = closing_price_y;
        this.chang_amount = chang_amount;
        this.chang_extent = chang_extent;
        this.change_hand_rate = change_hand_rate;
        this.turnover_amount = turnover_amount;
        this.turnover_money = turnover_money;
        this.total_market_value = total_market_value;
        this.circulation_market_value = circulation_market_value;
    }

    public Data getStock_date() {
        return stock_date;
    }

    public void setStock_date(Data stock_date) {
        this.stock_date = stock_date;
    }

    public String getStock_id() {
        return stock_id;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
    }

    public String getTock_name() {
        return tock_name;
    }

    public void setTock_name(String tock_name) {
        this.tock_name = tock_name;
    }

    public double getClosing_price_t() {
        return closing_price_t;
    }

    public void setClosing_price_t(double closing_price_t) {
        this.closing_price_t = closing_price_t;
    }

    public double getHeighst_price() {
        return heighst_price;
    }

    public void setHeighst_price(double heighst_price) {
        this.heighst_price = heighst_price;
    }

    public double getLowest_price() {
        return lowest_price;
    }

    public void setLowest_price(double lowest_price) {
        this.lowest_price = lowest_price;
    }

    public double getOpening_price() {
        return opening_price;
    }

    public void setOpening_price(double opening_price) {
        this.opening_price = opening_price;
    }

    public double getClosing_price_y() {
        return closing_price_y;
    }

    public void setClosing_price_y(double closing_price_y) {
        this.closing_price_y = closing_price_y;
    }

    public float getChang_amount() {
        return chang_amount;
    }

    public void setChang_amount(float chang_amount) {
        this.chang_amount = chang_amount;
    }

    public float getChang_extent() {
        return chang_extent;
    }

    public void setChang_extent(float chang_extent) {
        this.chang_extent = chang_extent;
    }

    public float getChange_hand_rate() {
        return change_hand_rate;
    }

    public void setChange_hand_rate(float change_hand_rate) {
        this.change_hand_rate = change_hand_rate;
    }

    public String getTurnover_amount() {
        return turnover_amount;
    }

    public void setTurnover_amount(String turnover_amount) {
        this.turnover_amount = turnover_amount;
    }

    public String getTurnover_money() {
        return turnover_money;
    }

    public void setTurnover_money(String turnover_money) {
        this.turnover_money = turnover_money;
    }

    public String getTotal_market_value() {
        return total_market_value;
    }

    public void setTotal_market_value(String total_market_value) {
        this.total_market_value = total_market_value;
    }

    public String getCirculation_market_value() {
        return circulation_market_value;
    }

    public void setCirculation_market_value(String circulation_market_value) {
        this.circulation_market_value = circulation_market_value;
    }

}
