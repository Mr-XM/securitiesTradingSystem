package com.haoding.demo.controller;

import com.haoding.demo.service.serviceImpl.ForumTopicServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/forumTopic")
public class ForumTopicController {
    @Autowired
    ForumTopicServiceImpl forumTopicService;

    @GetMapping("/getForumInfo")
    @ResponseBody
    @ApiOperation(value = "根据股票代码获取当前股票的全部股吧的帖子")
    public String getForumInfo(String stockId){
        String msg= forumTopicService.getForumInfo(stockId);
        return msg;
    }

    @GetMapping("/getHotForumInfo")
    @ResponseBody
    @ApiOperation(value = "根据股票代码获取热门帖子信息")
    public String getHotForumInfo(String stockId){
        String msg= forumTopicService.getHotForumInfo(stockId);
        return msg;
    }

    @GetMapping("/getOwnForumInfo")
    @ResponseBody
    @ApiOperation(value = "根据用户名获取自己的帖子")
    public String getOwnForumInfo(String userName){
        String msg= forumTopicService.getOwnForumInfo(userName);
        return msg;
    }

    @PostMapping("/addForum")
    @ResponseBody
    @ApiOperation(value = "发帖")
    public String addForum(String post_title,String post_text,String user_name,String stock_id){
        String msg= forumTopicService.addForum(post_title,post_text,user_name,stock_id);
        return msg;
    }

    @PostMapping("/delForum")
    @ResponseBody
    @ApiOperation(value = "根据帖子id删除帖子")
    public String delForum(int post_id){
        String msg=forumTopicService.delForum(post_id);
        return msg;
    }

    @GetMapping("/getForumByPostId")
    @ResponseBody
    @ApiOperation(value = "根据帖子id获取帖子详情")
    public String getForumByPostId(int post_id){
        String msg=forumTopicService.getForumByPostId(post_id);
        return msg;
    }


    @PostMapping("/changeForumReadNumber")
    @ResponseBody
    @ApiOperation(value = "根据帖子id获取帖子详情")
    public String changeForumReadNumber(int post_id){
        String msg=forumTopicService.changeForumReadNumber(post_id);
        return msg;
    }

}
