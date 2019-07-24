package com.haoding.demo.mapper;

import com.haoding.demo.config.DS;
import org.apache.ibatis.annotations.Param;


import java.util.ArrayList;
import java.util.List;

public interface StockDataMapper {
    //@DS(value = "dataSource2")
    ArrayList getStockData(@Param("stockCode")String stockCode);
}
