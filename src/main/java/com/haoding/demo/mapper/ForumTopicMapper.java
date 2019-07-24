package com.haoding.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Map;

public interface ForumTopicMapper {
    ArrayList getForumInfo(@Param("stockId") String stockId);
    boolean addForum(@Param("post_title") String post_title,@Param("post_text") String post_text,@Param("post_time") String post_time,@Param("user_name") String user_name,@Param("post_id") int post_id,@Param("stock_id") String stock_id,@Param("post_read") String post_read,@Param("stock_comment")String stock_comment);
    boolean delForum(@Param("post_id") int post_id);
    ArrayList getHotForumInfo(@Param("stockId") String stockId);
    ArrayList getOwnForumInfo(@Param("phone") String phone);
    Map getForumByPostId(@Param("post_id") int post_id);
    boolean updateCommentNumber(@Param("post_id") int post_id,@Param("stock_comment") String stock_comment);
    String selectCommentNumber(@Param("post_id") int post_id);
    String getForumReadNumber(@Param("post_id") int post_id);
    boolean changeForumReadNumber(@Param("post_id") int post_id,@Param("post_read") String post_read);
}
