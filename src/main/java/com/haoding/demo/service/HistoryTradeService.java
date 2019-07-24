package com.haoding.demo.service;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface HistoryTradeService {
    String queryHoldShares(String userId);
    String delHoldShares(String entrustId);
    String addHoldShares(String entrustId,String userId,String stockId,String restingOrderTime,int number,double price,int canUserNumber,String station);
}
