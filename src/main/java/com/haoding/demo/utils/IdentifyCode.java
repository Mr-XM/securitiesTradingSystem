package com.haoding.demo.utils;

import java.util.Random;

public class IdentifyCode {
    public static String createIdentifyCode(int codeLongth){
        String code="";
        Random random=new Random();
        for(int i=0;i<codeLongth;i++){
            code =code +random.nextInt(10);
        }
        return code;
    }
}
