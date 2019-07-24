package com.haoding.demo.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.haoding.demo.config.DataSourceHelper;
import com.haoding.demo.mapper.HistoryTradeMapper;
import com.haoding.demo.service.HistoryTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class HistoryTradeServiceImpl implements HistoryTradeService {
    @Autowired
    HistoryTradeMapper historyTradeMapper;

    public String queryHoldShares(String userId){
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        ArrayList list =historyTradeMapper.queryHoldShares(userId);
        return JSON.toJSONString(list);
    }

    public String delHoldShares(String entrustId){
        Map map=new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        boolean flag=historyTradeMapper.delHoldShares(entrustId);
        map.put("success",flag);
        return JSON.toJSONString(map);
    }
    public String addHoldShares(String entrustId,String userId,String stockId,String restingOrderTime,int number,double price,int canUserNumber,String station){
        Map map=new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        boolean flag=historyTradeMapper.addHoldShares(entrustId,userId,stockId,restingOrderTime,number,price,canUserNumber,station);
        map.put("success",flag);
        return JSON.toJSONString(map);
    }
    

}
