package com.haoding.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface EntrustMapper {
    /**
     * 挂单
     * @param
     * @param userId 用户Id
     * @param stockId 股票Id
     * @param restingOrderTime 挂单时间
     * @param number 数量
     * @param price 单价
     * @param type 类型buy或sell
     * @return
     */
    boolean restingOrder(@Param("entrustId") String entrustId, @Param("userId") String userId,@Param("stockId") String stockId, @Param("restingOrderTime") String restingOrderTime, @Param("number")int number, @Param("price")double price, @Param("type")String type,@Param("station") String station);

    /**
     * 撤单
     * @param entrustId
     * @param cancellationTime
     * @return
     */
    boolean cancellation(@Param("entrustId")String entrustId,@Param("cancellationTime") String cancellationTime);

    ArrayList queryResting(@Param("user_id") String user_id,@Param("time") String time);
    ArrayList queryEntrust(@Param("user_id") String user_id,@Param("time") String time);
    ArrayList queryPurchase(@Param("user_id") String user_id,@Param("time") String time);
    boolean updateStation(@Param("station") String station,@Param("entrust_id") String entrust_id);
}
