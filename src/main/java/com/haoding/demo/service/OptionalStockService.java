package com.haoding.demo.service;


public interface OptionalStockService {
    String addOptionalStock(String user_id,String stock_name,String stock_id);
    String delOptionalStock(String user_id,String stock_id);
    String selectOptionalStock(String user_id);
}
