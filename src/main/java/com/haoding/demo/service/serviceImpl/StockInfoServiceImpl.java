package com.haoding.demo.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.haoding.demo.config.DataSourceHelper;
import com.haoding.demo.mapper.StockInfoMapper;
import com.haoding.demo.service.StockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class StockInfoServiceImpl implements StockInfoService {
    @Autowired
    private StockInfoMapper stockInfoMapper;

    @Override
    public String getStockName(String stockCode) {
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        String stockName=stockInfoMapper.getStockNameByStockCode(stockCode);
        if(stockName==null){
            return "";
        }
        else {
            return stockName;
        }
    }

    @Override
    public String getInitialization(){
        String a[]={"600006","600000","600004","600010"};
        String initialization="";
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        ArrayList list=stockInfoMapper.getInitialization();
        /*for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }*/
        for(int i=0;i<a.length;i++){
            ArrayList list1=stockInfoMapper.getStockInfoByStockId(a[i]);
            list.add(list1.get(0));
        }
        initialization = JSON.toJSONString(list);
        return initialization;

    }

    public String getStockInfoByStockCode(String stockCode){
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        Map map=stockInfoMapper.getStockInfoByStockCode(stockCode);
        if(!map.isEmpty()){
            if(map.get("stock_type").toString().equals("2")){
                map.put("stock_type","sz");
            }else {
                map.put("stock_type","sh");
            }
            map.put("success",true);
            map.put("stockCode",stockCode);
            return JSON.toJSONString(map);
        }
        map.put("success",false);
        map.put("msg","股票不存在");
        return JSON.toJSONString(map);
        }

}
