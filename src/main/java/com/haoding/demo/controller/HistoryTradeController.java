package com.haoding.demo.controller;

import com.alibaba.fastjson.JSON;
import com.haoding.demo.service.serviceImpl.HistoryTradeServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/historyTrade")
public class HistoryTradeController {
    @Autowired
    HistoryTradeServiceImpl historyTradeService;
    /**
     *
     * @param user_id
     * @return
     */
    @GetMapping("/queryHoldShares")
    @ResponseBody
    @ApiOperation(value = "查询当日成交")
    public String queryHoldShares(String user_id){
        String msg=historyTradeService.queryHoldShares(user_id);
        return msg;

        /*ArrayList arrayList=new ArrayList();
        Map map = new HashMap();
        map.put("entrust_id","1231131");
        map.put("stock_id","000727");
        map.put("user_id","12313211");
        map.put("time","2019-06-01 11:10:00");
        map.put("stock_name","我也网络");
        map.put("number",1100);
        map.put("useNumber",500);
        map.put("price",11.5);
        map.put("gain","3.0%");
        map.put("gainPrice",300);
        map.put("value",3000);
        map.put("nowPrice",12.0);


        Map map1 = new HashMap();
        map1.put("entrust_id","1231131");
        map1.put("stock_id","000001");
        map1.put("user_id","12313211");
        map1.put("time","2019-06-01 11:10:00");
        map1.put("stock_name","我网络");
        map1.put("number",1100);
        map1.put("useNumber",500);
        map1.put("price",11.5);
        map1.put("gain","3.0%");
        map1.put("gainPrice",300);
        map1.put("value",3000);
        map1.put("nowPrice",12.0);


        arrayList.add(map);
        arrayList.add(map1);
        return JSON.toJSONString(arrayList);*/
    }

    @PostMapping("/delHoldShares")
    @ResponseBody
    @ApiOperation(value = "删除持仓股票数据",notes = "该接口主要在测试的时候使用，禁止在前端调用，开发完成便关闭")
    public String delHoldShares(String entrustId){
        String msg=historyTradeService.delHoldShares(entrustId);
        return msg;
    }

    @PostMapping("/addHoldShares")
    @ResponseBody
    @ApiOperation(value = "添加持仓股票数据",notes = "该接口主要在测试的时候使用，禁止在前端调用，开发完成便关闭")
    public String addHoldShares(String entrustId,String userId,String stockId,String restingOrderTime,int number,double price,int canUserNumber,String station){
        String msg=historyTradeService.addHoldShares(entrustId,userId,stockId,restingOrderTime,number,price,canUserNumber,station);
        return msg;
    }
}
