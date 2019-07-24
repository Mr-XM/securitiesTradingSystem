package com.haoding.demo.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.haoding.demo.config.DataSourceHelper;
import com.haoding.demo.mapper.StockDataMapper;
import com.haoding.demo.service.StockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StockDataServiceImpl implements StockDataService {
    @Autowired
    private StockDataMapper stockDataMapper;

    @Override
    public String getStockData(String stockCode) {
        String stockData = "";
        String date = "";
        String a = "";
        String c = "";
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource2");
        ArrayList list = stockDataMapper.getStockData(stockCode);
        for (int i = 0; i < list.size(); i++) {
            c = list.get(i).toString().replace("{", "[").replace("}", "]").replace("opening_price=", "").replace("closing_price_t=", "").replace("heighst_price=", "").replace("lowest_price=", "").replace("stock_date=", "").replace("-", "/");
            date = "'";
            a = c.substring(1, 11);
            date = date + a + "'";
            c = c.replace(a, date);
            stockData = stockData + c;
            if (i + 1 < list.size()) {
                stockData = stockData + ";";
            }
        }
        System.out.println("获取数据成功");
        stockData = stockData.replace(" ", "");
        return stockData;

    }
}
