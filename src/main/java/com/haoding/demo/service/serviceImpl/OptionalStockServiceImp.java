package com.haoding.demo.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.haoding.demo.config.DataSourceHelper;
import com.haoding.demo.mapper.OptionalStockMapper;
import com.haoding.demo.service.OptionalStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class OptionalStockServiceImp implements OptionalStockService {
    @Autowired
    OptionalStockMapper optionalStockMapper;
    public String addOptionalStock(String user_id,String stock_name,String stock_id){
        String msg="";
        Map map = new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        boolean flag=optionalStockMapper.addOptionalStock(user_id,stock_name,stock_id);
        map.put("success",flag);
        msg= JSON.toJSONString(map);
        return msg;
    }
    public String delOptionalStock(String user_id,String stock_id){
        String msg="";
        Map map = new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        boolean flag=optionalStockMapper.delOptionalStock(user_id,stock_id);
        map.put("success",flag);
        msg= JSON.toJSONString(map);
        return msg;
    }
    public String selectOptionalStock(String user_id){
        String msg="";
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        ArrayList arrayList = optionalStockMapper.selectOptionalStock(user_id);
        msg= JSON.toJSONString(arrayList);
        return msg;
    }
}
