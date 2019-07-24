package com.haoding.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    boolean createUser(@Param("password") String password,@Param("phoneNumber") String phoneNumber);
    boolean openUser(@Param("phone") String phone,@Param("userName") String userName,@Param("userSex") String userSex,@Param("accountType") String accountType,@Param("accountNum") String accountNum,@Param("userId") String userId,@Param("account_balance") double account_balance,@Param("account_password") String account_password);
    int login(@Param("phone") String phone, @Param("password") String password);
    int isExistOfPhoneNum(@Param("phone") String phone);
    String isOpenUser(@Param("phone") String phone);
    Map getAccountBalance(@Param("phone")String phone);
    boolean updateAccountBalance(@Param("phone")String phone,@Param("account_balance") double account_balance);
}
