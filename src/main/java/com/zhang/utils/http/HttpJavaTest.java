package com.zhang.utils.http;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * JAVA模拟HTTP请求调用api接口
 *
 * @author zhangyu
 * @create 2018-05-23 13:54
 **/
public class HttpJavaTest {

    public static Map getResult(String info) {
        // 接口地址
        String requestUrl = "http://iplocation.com";
        // params用于存储要请求的参数
        Map params = new HashMap(16);
        params.put("ip", info);

        // 调用httpRequest方法，这个方法主要用于请求地址，并加上请求参数
        String responStr = httpRequest(requestUrl, params, "POST");

        // 处理返回的JSON数据并返回
        String lat = JSONObject.parseObject(responStr).getString("lat");
        String lng = JSONObject.parseObject(responStr).getString("lng");

        Map result = new HashMap(16);
        result.put("lat", lat);
        result.put("lng", lng);

        return result;
    }

    /**
     * 模拟发送HTTP请求
     *
     * @param requestUrl
     * @param params
     * @param methodType
     * @return
     */
    private static String httpRequest(String requestUrl, Map params, String methodType) {
        // buffer用于接受返回的字符
        StringBuffer buffer = new StringBuffer();
        try {
            // 建立URL，把请求地址给补全，其中urlencode（）方法用于把params里的参数给取出来
            URL url = new URL(requestUrl + "?" + urlencode(params));
            // 打开http连接
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod(methodType);
            httpUrlConn.connect();

            // 获得输入
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // 将bufferReader的值给放到buffer里
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 关闭bufferReader和输入流
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            // 断开连接
            httpUrlConn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回字符串
        return buffer.toString();
    }

    /**
     * 拼接map参数
     * 拼接成'id=###&name=###&的样子'
     *
     * @param data
     * @return
     */
    public static String urlencode(Map<String, Object> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Map result = getResult("120.193.111.7");
        Set keySet = result.keySet();
        for (Object key : keySet) {
            String value = (String) result.get(key);
            System.out.println(key + "->" + value);
        }
    }

}
