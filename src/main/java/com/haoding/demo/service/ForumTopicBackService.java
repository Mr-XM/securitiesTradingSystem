package com.haoding.demo.service;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ForumTopicBackService {
    String addReply(int post_id,String user_name,String reply_Text,String stock_id);
    String delReply(String reply_id);
    String selectReply(int post_id);
}
