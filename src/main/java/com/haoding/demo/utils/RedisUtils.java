package com.haoding.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * redis操作工具类
 * (基于RedisTemplate)
 * @author zhangyinghao
 */
@Component
public class RedisUtils {
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 设置key和value的序列化函数
     * @param redisTemplate
     */
    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }
    private Logger logger= LoggerFactory.getLogger(RedisUtils.class);

    public void set(String key,String value,long time){
        boolean isExisted= redisTemplate.hasKey(key);
        if(isExisted){
            logger.info("this key is bExistent!");
        }else{
            redisTemplate.opsForValue().set(key,value,time, TimeUnit.SECONDS);
        }
    }

    /**
     * 根据key获得对应的value
     * @param key
     * @return
     */
    public String get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 根据key删除对应该键值对
     * @param key
     * @return
     */
    public boolean del(String key){
        return redisTemplate.delete(key);
    }

    /**
     * 更新关键字
     * @param key
     * @param value
     * @return
     */
    public boolean getAndSet(String key,String value,long time){
        boolean result=false;
        try{
            //redisTemplate.opsForValue().getAndSet(key,value);
            del(key);
            set(key,value,time);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
