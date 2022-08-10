package com.ps.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Weather {

    //日期
    public static String getDate(){
        SimpleDateFormat today = new SimpleDateFormat("yyyy年MM月dd日    EEEE");
        String date = today.format(new Date());
        return date;
    }

    //最高温度
    public static String getMaxWeather() {
        String strURL = "http://flash.weather.com.cn/wmaps/xml/shenzhen.xml";
        String maxTem = null;
        try {
            URL url = new URL(strURL);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            InputStreamReader input = null;
            input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
            BufferedReader bufReader = new BufferedReader(input);
            String line = "";
            StringBuilder contentBuf = new StringBuilder();
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
            }
            String buf = contentBuf.toString();

            int beginIndex = buf.indexOf("tem1");
            int endIndex = buf.indexOf("tem2");
            String tem1 = buf.substring(beginIndex, endIndex);
            maxTem = tem1.substring(6, tem1.length() - 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxTem;
    }

    //最低温度
    public static String getMinWeather() {
        String strURL = "http://flash.weather.com.cn/wmaps/xml/shenzhen.xml";
        String minTem = null;
        try {
            URL url = new URL(strURL);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            InputStreamReader input = null;
            input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
            BufferedReader bufReader = new BufferedReader(input);
            String line = "";
            StringBuilder contentBuf = new StringBuilder();
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
            }
            String buf = contentBuf.toString();

            int beginIndex = buf.indexOf("tem2");
            int endIndex = buf.indexOf("temNow");
            String tem2 = buf.substring(beginIndex, endIndex);
            minTem = tem2.substring(6, tem2.length() - 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return minTem;
    }

    //城市名
    public static String getCity() {
        String strURL = "http://flash.weather.com.cn/wmaps/xml/shenzhen.xml";
        String cityName = null;
        try {
            URL url = new URL(strURL);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            InputStreamReader input = null;
            input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
            BufferedReader bufReader = new BufferedReader(input);
            String line = "";
            StringBuilder contentBuf = new StringBuilder();
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
            }
            String buf = contentBuf.toString();

            int beginIndex = buf.indexOf("cityname");
            int endIndex = buf.indexOf("centername");
            String city = buf.substring(beginIndex, endIndex);
            cityName = city.substring(10, city.length() - 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityName;
    }

    //天气
    public static String getWeather() {
        String strURL = "http://flash.weather.com.cn/wmaps/xml/shenzhen.xml";
        String weather = null;
        try {
            URL url = new URL(strURL);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            InputStreamReader input = null;
            input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
            BufferedReader bufReader = new BufferedReader(input);
            String line = "";
            StringBuilder contentBuf = new StringBuilder();
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
            }
            String buf = contentBuf.toString();

            int beginIndex = buf.indexOf("stateDetailed");
            int endIndex = buf.indexOf("tem1");
            String weatherString = buf.substring(beginIndex, endIndex);
            weather = weatherString.substring(15, weatherString.length() - 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }













    public static void main(String[] args) throws IOException {
        System.out.println(getMaxWeather());
    }

}
