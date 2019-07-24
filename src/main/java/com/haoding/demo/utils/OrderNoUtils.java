package com.haoding.demo.utils;

import java.util.Random;
import java.text.DecimalFormat;

public class OrderNoUtils {
    /**
     * 获取6-10 的随机位数数字
     * @param length	想要生成的长度
     * @return result
     */
    public static String getRandom620(Integer length) {
        String result = "";
        Random rand = new Random();
        int n = 20;
        if (null != length && length > 0) {
            n = length;
        }
        int randInt = 0;
        for (int i = 0; i < n; i++) {
            randInt = rand.nextInt(10);
            result += randInt;
        }
        return result;
    }
    public static double getRandom(){
        Random random = new Random();
        double d=random.nextDouble()+3000;
        DecimalFormat    df   = new DecimalFormat("######0.00");
        return Double.parseDouble(df.format(d));
    }
}
