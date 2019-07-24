package com.haoding.demo.utils;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

public class DataInfoUtils {
    public static String getURLContent(String stockCode,String type) {
        String urlStr = "http://hq.sinajs.cn/list="+type+stockCode;
        //请求的url
        URL url = null;
        //请求的输入流
        BufferedReader in = null;
        //输入流的缓冲
        StringBuffer sb = new StringBuffer();
        try{
            url = new URL(urlStr);
            in = new BufferedReader(new InputStreamReader(url.openStream(),"gbk") );
            String str = null;
            //一行一行进行读入
            while((str = in.readLine()) != null) {
                sb.append( str );
            }
        } catch (Exception ex) {

        } finally{
            try{
                if(in!=null) {
                    in.close(); //关闭流
                }
            }catch(IOException ex) {

            }
        }
        String result =sb.toString();
        String[] a=result.split("\"");
        String[] b=a[1].split(",");
        return b[3];
    }
}
