package com.haoding.demo.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.haoding.demo.config.DataSourceHelper;
import com.haoding.demo.mapper.ForumTopicMapper;
import com.haoding.demo.service.ForumTopicService;
import com.haoding.demo.utils.OrderNoUtils;
import com.haoding.demo.utils.TimeUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class ForumTopicServiceImpl implements ForumTopicService {
    @Autowired
    ForumTopicMapper forumTopicMapper;
    @Autowired
    ForumTopicBackServiceImpl forumTopicBackService;

    public String getForumInfo(String stockId){
        String msg="";
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        ArrayList list = forumTopicMapper.getForumInfo(stockId);
        msg= JSON.toJSONString(list);
        return msg;
    }

    public String getHotForumInfo(String stockId){
        String msg="";
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        ArrayList list = forumTopicMapper.getHotForumInfo(stockId);
        msg= JSON.toJSONString(list);
        return msg;
    }
    public String getOwnForumInfo(String phone){
        String msg="";
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        ArrayList list = forumTopicMapper.getOwnForumInfo(phone);
        msg= JSON.toJSONString(list);
        return msg;
    }
    public String addForum(String post_title,String post_text,String user_name,String stock_id){
        String msg="";
        Map map = new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        boolean flag = forumTopicMapper.addForum(post_title,post_text, TimeUtils.getNowTimeSimple(),user_name, Integer.parseInt(OrderNoUtils.getRandom620(4)),stock_id,"0","0");
        if(flag==true){
            map.put("success",true);
            msg= JSON.toJSONString(map);
            return msg;
        }
        map.put("success",false);
        msg= JSON.toJSONString(map);
        return msg;
    }

    public String delForum(int post_id){
        String msg="";
        Map map = new HashMap();
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        boolean flag = forumTopicMapper.delForum(post_id);
        if(flag==true){

            map.put("success",true);
            msg= JSON.toJSONString(map);
            return msg;
        }
        map.put("success",false);
        msg= JSON.toJSONString(map);
        return msg;
    }
    public String getForumByPostId(int post_id){
        String msg="";
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        Map map = forumTopicMapper.getForumByPostId(post_id);
        map.put("success",false);
        msg= JSON.toJSONString(map);
        return msg;
    }

    public String changeForumReadNumber(int post_id){
        String msg="";
        DataSourceHelper.setSqlSessionFactoryEnvironment("dataSource1");
        Map map =new HashMap();
        String number = forumTopicMapper.getForumReadNumber(post_id);
        int readNumber=Integer.parseInt(number)+1;
        boolean flag = forumTopicMapper.changeForumReadNumber(post_id,String.valueOf(readNumber));
        if(flag==true){
            map.put("success",true);
            msg= JSON.toJSONString(map);
            return msg;
        }
        map.put("success",false);
        msg= JSON.toJSONString(map);
        return msg;
    }
}
