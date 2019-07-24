package com.haoding.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface HistoryTradeMapper {
    /**
     *
     * @param entrustId
     * @param userId
     * @param stockId
     * @param restingOrderTime
     * @param number
     * @param price
     * @param canUserNumber
     * @param station
     * @return
     */
    boolean addHoldShares(@Param("entrustId") String entrustId, @Param("userId") String userId, @Param("stockId") String stockId, @Param("restingOrderTime") String restingOrderTime, @Param("number")int number, @Param("price")double price, @Param("canUserNumber")int canUserNumber,@Param("station") String station);

    /**
     * 查询持仓情况
     * @param userId
     * @return
     */
    ArrayList queryHoldShares(@Param("userId") String userId);

    boolean delHoldShares(@Param("entrustId") String entrustId);
}
