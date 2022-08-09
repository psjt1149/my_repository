package com.ps.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ps.util.Pusher;

@RestController
public class PushController {
    //要推送的用户openid
    private static String pp = "ozoSs6Ycmv0TAKeDTNbZQLhyzUvY";
    private static String tt = "ozoSs6ShO86kplNJMj0WswsbGHc8";


    /**
     * 微信测试账号推送
     */
    @GetMapping("/push/pp")
    public void pushPP() {
        Pusher.push(pp);
    }

    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/tt")
    public void pushTT() {
        Pusher.push(tt);
    }


    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/{id}")
    public void pushId(@PathVariable("id") String id) {
        Pusher.push(id);
    }
}