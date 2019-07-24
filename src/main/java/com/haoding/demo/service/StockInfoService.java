package com.haoding.demo.service;



public interface StockInfoService {
    String getStockName(String stockCode);
    String getInitialization();
    String getStockInfoByStockCode(String stockCode);
}
