package com.haoding.demo.controller;

import com.alibaba.fastjson.JSON;
import com.haoding.demo.service.serviceImpl.EntrustServiceImpl;
import com.haoding.demo.utils.TimeUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *  委托交易的控制器
 */
@RestController
//@RequestMapping("/entrust")
public class EntrustController {
    @Autowired
    EntrustServiceImpl entrustService;

    /**
     * 挂单
     * @param userId
     * @param stockId
     * @param number
     * @param price
     * @param type
     * @return
     */
    @GetMapping("/restingOrder")
    @ResponseBody
    @ApiOperation(value = "挂单",notes = "用户添加操作")
    public String restingOrder(String userId,String stockId,int number,double price,String type){
        Map map =new HashMap();
        String msg="";
        String restingOrderTime = TimeUtils.getNowTime();
        boolean flag=entrustService.restingOrder(userId,stockId,restingOrderTime,number,price,type);
        map.put("success",flag);
        msg= JSON.toJSONString(map);
        return msg;
    }

    @GetMapping("/cancellation")
    @ResponseBody
    @ApiOperation(value = "撤单",notes = "用户操作")
    public String cancellation(String entrustId){
        String msg=entrustService.cancellation(entrustId);
        return msg;
    }

    /**
     *
     * @param phone
     * @return
     */
    @GetMapping("/queryResting")
    @ResponseBody
    @ApiOperation(value = "查询当日挂单")
    public String queryResting(String phone){
        String msg=entrustService.queryResting(phone);
        return msg;
    }

    /**
     *
     * @param phone
     * @return
     */
    @GetMapping("/queryEntrust")
    @ResponseBody
    @ApiOperation(value = "查询当日委托")
    public String queryEntrust(String phone){
        String msg=entrustService.queryEntrust(phone);
        return msg;

    }


    /**
     *
     * @param phone
     * @return
     */
    @GetMapping("/queryPurchase")
    @ResponseBody
    @ApiOperation(value = "查询当日成交")
    public String queryPurchase(String phone){
        String msg=entrustService.queryPurchase(phone);
        return msg;
    }



}
