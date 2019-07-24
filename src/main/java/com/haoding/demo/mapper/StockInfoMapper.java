package com.haoding.demo.mapper;

import com.haoding.demo.config.DS;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Map;

public interface StockInfoMapper {

    String getStockNameByStockCode(@Param("stockCode") String stockCode);
    ArrayList getInitialization();
    ArrayList getStockInfoByStockId(@Param("stockCode") String stockCode);
    Map getStockInfoByStockCode(@Param("stockCode") String stockCode);
}