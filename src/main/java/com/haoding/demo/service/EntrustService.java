package com.haoding.demo.service;

import org.apache.ibatis.annotations.Param;

public interface EntrustService {
    boolean restingOrder(String userId,String stockId,String restingOrderTime,int number,double price,String type);
    String cancellation(String entrustId);
    String queryResting(String phone);
    String queryEntrust(String phone);
    String queryPurchase(String phone);
}
