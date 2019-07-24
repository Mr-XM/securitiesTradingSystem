package com.haoding.demo.controller;

import com.haoding.demo.service.serviceImpl.OptionalStockServiceImp;
import com.haoding.demo.service.serviceImpl.StockDataServiceImpl;
import com.haoding.demo.service.serviceImpl.StockInfoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/main")
public class MainController {
    @Autowired
    private StockDataServiceImpl stockDataService;
    @Autowired
    private StockInfoServiceImpl stockInfoService;
    @Autowired
    private OptionalStockServiceImp optionalStockServiceImp;

    @GetMapping("/getStockData")
    @ResponseBody
    @ApiOperation(value = "获取股票的全部历史数据" )
    public String getStockData(String stockCode) {
        String stockName = stockInfoService.getStockName(stockCode);
        if(!"".equals(stockName)){
            String stockData = stockDataService.getStockData(stockCode);
            return stockData;
        }
        return "";
    }

    @GetMapping("/getStockName")
    @ResponseBody
    @ApiOperation(value = "根据股票代码获取股票的名字")
    public String getStockName(String stockCode) {
        String stockName = stockInfoService.getStockName(stockCode);
        return stockName;
    }


    @GetMapping("/getStockInfoByStockCode")
    @ResponseBody
    @ApiOperation(value = "根据股票代码获取股票的信息")
    public String getStockInfoByStockCode(String stockCode) {
        String stockName = stockInfoService.getStockInfoByStockCode(stockCode);
        return stockName;
    }


    /**
     * 获得主页初始数据
     * @return
     */
    @GetMapping("/getInitialization")
    @ResponseBody
    @ApiOperation(value = "首页初始页面的股票数据")
    public String getInitialization(){
        String initialization=stockInfoService.getInitialization();
        return initialization;
    }

    /**
     * 添加自选股
     * @param phone
     * @param stock_name
     * @param stock_id
     * @return
     */
    @PostMapping("/addOptionalStock")
    @ResponseBody
    @ApiOperation(value = "添加自选股")
    public String addOptionalStock(String phone,String stock_name,String stock_id){
        String msg=optionalStockServiceImp.addOptionalStock(phone,stock_name,stock_id);
        return msg;
    }

    @PostMapping("/delOptionalStock")
    @ResponseBody
    @ApiOperation(value = "删除自选股")
    public String delOptionalStock(String phone,String stock_id){
        String msg=optionalStockServiceImp.delOptionalStock(phone,stock_id);
        return msg;
    }

    @GetMapping("/selectOptionalStock")
    @ResponseBody
    @ApiOperation(value = "查询我的自选股")
    public String selectOptionalStock(String phone){
        String msg=optionalStockServiceImp.selectOptionalStock(phone);
        return msg;
    }
}
