package com.haoding.demo.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.haoding.demo.config.DataSourceHelper;
import com.haoding.demo.mapper.UserMapper;
import com.haoding.demo.service.UserService;
import com.haoding.demo.utils.OrderNoUtils;
import com.haoding.demo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisUtils redisUtils;
    public String createUser(String password,String phone_number){
        String msg="";
        Map map = new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        int isexist=userMapper.isExistOfPhoneNum(phone_number);
        if(isexist==0){
            boolean flag=userMapper.createUser(password,phone_number);
            if(flag==true){
                map.put("phone",phone_number);
                map.put("password",password);
                map.put("success",true);
                msg = JSON.toJSONString(map);
            }
        }else {
            map.put("success",false);
            map.put("msg","账户已存在");
            msg = JSON.toJSONString(map);
        }
        return msg;
    }
    public String openUser(String phone_number,String userName,String userSex,String accountType,String accountNum,String account_password){
        String msg="";
        Map map = new HashMap();
        String userId=OrderNoUtils.getRandom620(10);
        double account_balance = OrderNoUtils.getRandom();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        boolean flag=userMapper.openUser(phone_number,userName,userSex,accountType,accountNum,userId,account_balance,account_password);
        if(flag==true){
            map.put("user_id",userId);
            map.put("user_name",userName);
            map.put("user_sex",userSex);
            map.put("account_type",accountType);
            map.put("account_num",accountNum);
            map.put("account_balance",account_balance);
            map.put("success",true);
            msg=JSON.toJSONString(map);
            return msg;
        }
        map.put("success",false);
        msg = JSON.toJSONString(map);
        return msg;
    }
    public String login(String phone,String password){
        String msg="";
        Map map = new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        int flag=userMapper.login(phone,password);
        if(flag>0){
            map.put("phone",phone);
            map.put("password",password);
            map.put("success",true);
            msg=JSON.toJSONString(map);
            return msg;
        }
        map.put("success",false);
        msg = JSON.toJSONString(map);
        return msg;
    }
    /**
     * @param phoneNum
     * @param code
     * @return
     * @desprition 通过过短信验证码进行登陆判断
     * @author zhangyinghao
     */
    public boolean checkLoginByMessage(String phoneNum, String code) {
        int isExist = 0;
        try {
            DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
            isExist = userMapper.isExistOfPhoneNum(phoneNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isExist != 0) {
            String value = redisUtils.get(phoneNum);
            if (code.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean isExistOfAccount(String phoneNum){
        int isExist = 0;
        try {
            DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
            isExist = userMapper.isExistOfPhoneNum(phoneNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(isExist!=0){
            return true;
        }
        return false;
    }
    public String  isOpenUser(String phone){
        String msg="";
        Map map=new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        msg=userMapper.isOpenUser(phone);
        //System.out.println(msg);
        if(null==msg){
            map.put("success",false);
        }else{
            map.put("success",true);
        }
        return JSON.toJSONString(map);

    }
    public String getAccountBalance(String phone){
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        Map map=userMapper.getAccountBalance(phone);
        return JSON.toJSONString(map);

    }

    public String updateAccountBalance(String phone,double account_balance){
        Map map=new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        boolean flag=userMapper.updateAccountBalance(phone,account_balance);
        map.put("success",flag);
        return JSON.toJSONString(map);
    }

}
