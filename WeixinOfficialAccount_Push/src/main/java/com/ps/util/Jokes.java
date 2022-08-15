package com.ps.util;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Jokes {


    private static String key = "c53d6068ace6b7826450d08a72fb45f4";
    private static String url = "http://api.tianapi.com/joke/index?key=";
    private static List<String> jinJuList = new ArrayList<>();
    private static String num = "&num=1";

    public static String getJokesText() {
        //默认题目
        String title = "骑车";
        //默认笑话
        String joke = "某人骑车，听见一个路人在狂吼：go，go，go……心想，妈的我也会唱：奥来奥来哦……话音未落，一头栽进沟里。路人骂道：妈的！告诉你沟沟沟，你还骑？摔死活该!";
        try {
            JSONObject jsonObject = JSONObject.parseObject(HttpUtil.getUrl(url + key + num));
            System.out.println(jsonObject);
            if (jsonObject.getIntValue("code") == 200) {
                joke = jsonObject.getJSONArray("newslist").getJSONObject(0).getString("content");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return joke;
    }


}

