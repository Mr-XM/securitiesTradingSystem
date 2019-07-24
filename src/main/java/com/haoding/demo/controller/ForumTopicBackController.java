package com.haoding.demo.controller;

import com.haoding.demo.service.serviceImpl.ForumTopicBackServiceImpl;
import com.haoding.demo.service.serviceImpl.ForumTopicServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 贴吧回复
 */
@RestController
//@RequestMapping("/forumTopicBack")
public class ForumTopicBackController {
    @Autowired
    ForumTopicBackServiceImpl forumTopicBackService;
    /**
     * 添加评论
     * @param user_name
     * @param reply_Text
     * @param stock_id
     * @return
     */
    @PostMapping("/addReply")
    @ResponseBody
    @ApiOperation(value = "添加回复")
    public String addReply(int post_id,String user_name,String reply_Text,String stock_id){
        String msg=forumTopicBackService.addReply(post_id,user_name,reply_Text,stock_id);
        return msg;
    }

    @PostMapping("/delReply")
    @ResponseBody
    @ApiOperation(value = "删除回复")
    public String delReply(String reply_id){
        String msg=forumTopicBackService.delReply(reply_id);
        return msg;
    }

    @GetMapping("/selectReply")
    @ResponseBody
    @ApiOperation(value = "根据帖子id查询回复")
    public String selectReply(int post_id){
        String msg=forumTopicBackService.selectReply(post_id);
        return msg;
    }
}
