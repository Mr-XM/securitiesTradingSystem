package com.haoding.demo;

import com.haoding.demo.service.EntrustService;
import com.haoding.demo.service.StockDataService;
import com.haoding.demo.service.serviceImpl.EntrustServiceImpl;
import com.haoding.demo.service.serviceImpl.StockDataServiceImpl;
import com.haoding.demo.service.serviceImpl.StockInfoServiceImpl;
import com.haoding.demo.service.serviceImpl.UserServiceImpl;
import com.haoding.demo.utils.OrderNoUtils;
import com.haoding.demo.utils.TimeUtils;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DemoApplicationTests {
    @Autowired
    StockDataServiceImpl stockDataService;
    @Autowired
    StockInfoServiceImpl stockInfoService;
    @Autowired
    EntrustServiceImpl entrustService;
    @Autowired
    UserServiceImpl userService;

    @Test
    public void test(){
        //System.out.println(stockDataService.getStockData("000001"));
        /*System.out.println(stockInfoService.getStockName("121221"));
        System.out.println(stockInfoService.getStockName("000003"));*/
        //System.out.println(stockInfoService.getStockName("000727"));
        /*System.out.println(stockInfoService.getInitialization());*/
        //System.out.println(OrderNoUtils.getRandom620(10));
        //System.out.println(entrustService.restingOrder(OrderNoUtils.getRandom620(10),"000727",TimeUtils.getNowTime(),500,10.3,"sell"));
        //System.out.println(stockInfoService.getStockInfoByStockCode("000727"));
        //System.out.println(stockInfoService.getStockInfoByStockCode("600000"));
        //System.out.println(userService.isOpenUser("12345678901"));
        //System.out.println(userService.isOpenUser("18846153430"));
        System.out.println(entrustService.queryResting("15912345678"));
        //System.out.println(entrustService.queryResting("641"));
        //System.out.println(entrustService.queryPurchase("13012345678"));

    }
}
