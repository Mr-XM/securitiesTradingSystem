package com.haoding.demo.service;


public interface ForumTopicService {
    String getForumInfo(String stockId);
    String addForum(String post_title,String post_text,String user_name,String stock_id);
    String getHotForumInfo(String stockId);
    String getOwnForumInfo(String phone);
    String delForum(int post_id);
    String getForumByPostId(int post_id);
    String changeForumReadNumber(int post_id);
}
