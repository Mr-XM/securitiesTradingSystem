package com.haoding.demo.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.haoding.demo.config.DataSourceHelper;
import com.haoding.demo.mapper.EntrustMapper;
import com.haoding.demo.mapper.UserMapper;
import com.haoding.demo.service.EntrustService;
import com.haoding.demo.utils.OrderNoUtils;
import com.haoding.demo.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class EntrustServiceImpl implements EntrustService {

    @Autowired
    private EntrustMapper entrustMapper;
    @Autowired
    UserMapper userMapper;

    public boolean restingOrder(String userId, String stockId, String restingOrderTime, int number, double price, String type) {
        boolean flag = false;
        Map map = new HashMap();
        String entrustId = OrderNoUtils.getRandom620(10);
        try {
            DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
            flag = entrustMapper.restingOrder(entrustId, userId, stockId, restingOrderTime, number, price, type,"已挂");
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public String cancellation(String entrustId) {
        String msg = "";
        Map map = new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        boolean flag = entrustMapper.cancellation(entrustId, TimeUtils.getNowTime());
        if(flag==true){
            entrustMapper.updateStation("已撤",entrustId);
        }
        map.put("success", flag);
        return JSON.toJSONString(map);

    }

    public String queryResting(String phone) {
        Map map = new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        String user_id = userMapper.isOpenUser(phone);
        if (user_id == null) {
            map.put("success", false);
            map.put("msg", "未开户，请先开户");
            return JSON.toJSONString(map);
        }
        ArrayList arrayList = entrustMapper.queryResting(user_id,TimeUtils.getTodayDate()+"%");
        if (!arrayList.isEmpty()) {
            map.put("success", true);
            arrayList.add(map);
            String msg = JSON.toJSONString(arrayList);
            msg = msg.replace("resting_order_time", "time").replace("sell", "卖").replace("buy", "买");
            return msg;
        }
        map.put("success", false);
        return JSON.toJSONString(map);
    }

    public String queryEntrust(String phone) {
        Map map = new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        String user_id = userMapper.isOpenUser(phone);
        if (user_id == null) {
            map.put("success", false);
            map.put("msg", "未开户，请先开户");
            return JSON.toJSONString(map);
        }
        ArrayList arrayList = entrustMapper.queryEntrust(user_id,TimeUtils.getTodayDate()+"%");
        if (!arrayList.isEmpty()) {
            map.put("success", true);
            arrayList.add(map);
            String msg = JSON.toJSONString(arrayList);
            msg = msg.replace("resting_order_time", "time").replace("sell", "卖").replace("buy", "买");
            return msg;
        }
        map.put("success", false);
        return JSON.toJSONString(map);
    }

    public String queryPurchase(String phone) {
        Map map = new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        String user_id = userMapper.isOpenUser(phone);
        if (user_id == null) {
            map.put("success", false);
            map.put("msg", "未开户，请先开户");
            return JSON.toJSONString(map);
        }
        ArrayList arrayList = entrustMapper.queryPurchase(user_id,TimeUtils.getTodayDate()+"%");
        if (!arrayList.isEmpty()) {
            map.put("success", true);
            arrayList.add(map);
            String msg = JSON.toJSONString(arrayList);
            msg = msg.replace("resting_order_time", "time").replace("sell", "卖").replace("buy", "买");
            return msg;
        }
        map.put("success", false);
        return JSON.toJSONString(map);
    }
}
