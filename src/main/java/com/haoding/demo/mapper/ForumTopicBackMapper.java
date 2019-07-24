package com.haoding.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ForumTopicBackMapper {
    boolean addReply(@Param("post_id") int post_id,@Param("user_name") String user_name,@Param("reply_time") String reply_time, @Param("reply_Text") String reply_Text,@Param("stock_id") String stock_id,@Param("reply_id") String reply_id);
    boolean delReply(@Param("reply_id") String reply_id);
    ArrayList selectReply(@Param("post_id") int post_id);
}
