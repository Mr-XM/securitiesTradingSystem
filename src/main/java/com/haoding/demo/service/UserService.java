package com.haoding.demo.service;

import org.apache.ibatis.annotations.Param;

public interface UserService {
    String createUser(String password,String phone_number);
    String openUser(String phone_number,String userName,String userSex,String accountType,String accountNum,String account_password);
    String login(String phone,String password);
    boolean checkLoginByMessage(String phoneNum,String code);
    boolean isExistOfAccount(String phoneNum);
    String isOpenUser(String phone);
    String getAccountBalance(String phone);
    String updateAccountBalance(String phone,double account_balance);
}
