package com.haoding.demo.controller;


import com.alibaba.fastjson.JSON;
import com.haoding.demo.service.serviceImpl.UserServiceImpl;
import com.haoding.demo.utils.JavaSmsApi;
import com.haoding.demo.utils.OrderNoUtils;
import com.haoding.demo.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    RedisUtils redisUtils;


    /**
     * 图片上传
     * @author
     *
     */
    @RestController
    public class PicUploadController {

        @PostMapping("/upload")
        public Object upload(MultipartFile fileUpload,String user_id,String type){
            System.out.println(user_id+" "+type);
            //获取文件名
            String fileName = fileUpload.getOriginalFilename();
            //获取文件后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //重新生成文件名
            fileName = "123"+suffixName;
            //指定本地文件夹存储图片
            String filePath="";
            if(type.equals("1")||type.equals("0")){
                return "fail to upload";
            }
            //头像
            if("1".equals(type)){
                filePath = "/Users/zhangyinghao/Desktop/userIcon/";
            }
            //生份证
            if("2".equals(type)){
                filePath = "/Users/zhangyinghao/Desktop/userIcon/";
            }
            try {
                //将图片保存到static文件夹里
                fileUpload.transferTo(new File(filePath+fileName));
                return "success to upload";
            } catch (Exception e) {
                e.printStackTrace();
                return "fail to upload";
            }

        }

    }
    @PostMapping("/createUser")
    @ResponseBody
    @ApiOperation(value = "注册账号")
    public String createUser(String password,String phone_number){
        String msg= userService.createUser(password,phone_number);
        return msg;
    }

    @PostMapping("/openUser")
    @ResponseBody
    @ApiOperation(value = "证劵开户")
    public String openUser(String phone_number,String userName,String userSex,String accountType,String accountNum,String account_password){
        String msg=userService.openUser(phone_number,userName,userSex,accountType,accountNum,account_password);
        return msg;
    }

    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "账号密码登录")
    public String login(String phone,String password){
        String msg=userService.login(phone,password);
        return msg;
    }

    /**
     * @description 通过短信登陆
     * @return
     */
    @PostMapping("/loginByMessagePost")
    @ResponseBody
    @ApiOperation(value = "通过手机验证码登录")
    public String loginPostByMessage(String phone, String code){
        Map<String, Boolean> msg = new HashMap<>();
        boolean isSuccess = false;
        isSuccess = userService.checkLoginByMessage(phone,code);
        if(isSuccess==true){
            redisUtils.set("online"+phone,"true",60*120);
        }
        msg.put("success",isSuccess);
        return JSON.toJSONString(msg);
    }

    @PostMapping("/sendMessage")
    @ResponseBody
    @ApiOperation(value = "发送短信接口")
    public String sendMessage(String phone){
        Map<String, Boolean> msg = new HashMap<>();
        String code = OrderNoUtils.getRandom620(6);
        String text = "【mr-xml】您的验证码是"+ code+"。如非本人操作，请忽略本短信";
        boolean isSuccess = false;
        isSuccess = userService.isExistOfAccount(phone);
        if(isSuccess==true){
            JavaSmsApi.sendSms(text,phone);
            System.out.println(text);
            redisUtils.set(phone,code,180);
            msg.put("success",true);
            return JSON.toJSONString(msg);
        }
        msg.put("success",false);
        return JSON.toJSONString(msg);

    }
    @GetMapping("/isOpenUser")
    @ResponseBody
    @ApiOperation(value = "判断用户是否开户")
    public String  isOpenUser(String phone){
        String msg=userService.isOpenUser(phone);
        return msg;
    }
    @GetMapping("/getAccountBalance")
    @ResponseBody
    @ApiOperation(value = "获得账户的余额")
    public String getAccountBalance(String phone){
        String msg=userService.getAccountBalance(phone);
        return msg;
    }

    @PostMapping("/changeAccountBalance")
    @ResponseBody
    @ApiOperation(value = "改变账户余额")
    public String ChangeAccountBalance(String phone,double account_balance){
        String msg=userService.updateAccountBalance(phone,account_balance);
        return msg;
    }

}
