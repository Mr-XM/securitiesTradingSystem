package com.haoding.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface OptionalStockMapper {
    boolean addOptionalStock(@Param("user_id") String user_id, @Param("stock_name") String stock_name,@Param("stock_id") String stock_id);
    boolean delOptionalStock(@Param("user_id")String user_id,@Param("stock_id")String stock_id);
    ArrayList selectOptionalStock(@Param("user_id")String user_id);
}
