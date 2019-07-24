package com.haoding.demo.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.haoding.demo.config.DataSourceHelper;
import com.haoding.demo.mapper.ForumTopicBackMapper;
import com.haoding.demo.mapper.ForumTopicMapper;
import com.haoding.demo.service.ForumTopicBackService;
import com.haoding.demo.utils.OrderNoUtils;
import com.haoding.demo.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class ForumTopicBackServiceImpl implements ForumTopicBackService {
    @Autowired
    ForumTopicBackMapper forumTopicBackMapper;
    @Autowired
    ForumTopicMapper forumTopicMapper;


    public String addReply(int post_id,String user_name,String reply_Text,String stock_id){
        Map map = new HashMap<>();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        boolean flag=forumTopicBackMapper.addReply(post_id,user_name,TimeUtils.getNowTimeSimple(),reply_Text,stock_id,OrderNoUtils.getRandom620(6));
        if(flag==true){
            String number = forumTopicMapper.selectCommentNumber(post_id);
            try {
                int commentNumber = Integer.parseInt(number);
                commentNumber=commentNumber+1;
                String stock_comment = String.valueOf(commentNumber);
                boolean flag1= forumTopicMapper.updateCommentNumber(post_id,stock_comment);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        map.put("success",flag);
        return JSON.toJSONString(map);
    }


    public String delReply(String reply_id){
        String msg="";
        Map map = new HashMap<>();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        boolean flag=forumTopicBackMapper.delReply(reply_id);
        map.put("success",flag);
        return JSON.toJSONString(map);
    }

    public String selectReply(int post_id){
        Map map = new HashMap<>();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        ArrayList arrayList=forumTopicBackMapper.selectReply(post_id);
        if(!arrayList.isEmpty()){
            map.put("success",true);
            arrayList.add(map);
            return JSON.toJSONString(arrayList);
        }
        map.put("success",false);
        return JSON.toJSONString(map);
    }
}
