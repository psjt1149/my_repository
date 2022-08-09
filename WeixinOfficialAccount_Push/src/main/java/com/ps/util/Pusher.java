package com.ps.util;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;


public class Pusher {
    /**
     * 测试号的appId和secret
     */
    private static String appId = "wxc0b6b9a29e8d9aeb";
    private static String secret = "5606627cfad39a44cf460d09e9718234";


    public static void push(String openId){
        //模版id
        String templateId = "ixtvgwZyj4oQXGOqtshQn1u9Caz1UbWlUqAFG5Nv9As";

        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(templateId)
                //.url("https://baidu.com/")//点击模版消息要访问的网址
                .build();

        //填写变量信息
        templateMessage.addData(new WxMpTemplateData("date",Weather.getDate() + "","#33A1C9"));
        templateMessage.addData(new WxMpTemplateData("weather",Weather.getWeather()+"","#FF9912"));
        templateMessage.addData(new WxMpTemplateData("city",Weather.getCity()+ "","#242421" ));
        templateMessage.addData(new WxMpTemplateData("maxTem",Weather.getMaxWeather()+ "","#FFC0CB" ));
        templateMessage.addData(new WxMpTemplateData("minTem",Weather.getMinWeather()+ "","#B0E0E6"));
        templateMessage.addData(new WxMpTemplateData("inLove",MemorableDay.getInLove()+"","#DA70D6"));
        templateMessage.addData(new WxMpTemplateData("birthdayOfGirl",MemorableDay.getBirthdayOfGirl()+"","#FFA500"));
        templateMessage.addData(new WxMpTemplateData("birthdayOfBoy",MemorableDay.getBirthdayOfBoy()+"","#FFA500"));
        templateMessage.addData(new WxMpTemplateData("sentences",Sentences.getSentences()+"","#7CFC00"));
        String notes = "";
        if(MemorableDay.getBirthdayOfBoy() % 365 == 0){
            notes = "今天是鹏鹏的生日！";
        }
        if(MemorableDay.getBirthdayOfGirl() % 365 == 0){
            notes = "今天是婷婷的生日！";
        }
        if(MemorableDay.getInLove() % 365 == 0){
            notes = "今天是周年纪念日！";
        }
        templateMessage.addData(new WxMpTemplateData("notes",notes,"#FF0000"));


        try {
            System.out.println("推送成功！");
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }


    }


    public static void water(String openId){
        //喝水模板id
        String templateId = "BGgMKX8utSjPwZ1uMENpRGr1TBmIh_O7vkpDmYA7J-E";

        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(templateId)
                .url("https://view.inews.qq.com/a/20210811A0568D00")  //点击模版消息要访问的网址
                .build();

        templateMessage.addData(new WxMpTemplateData("water",  Water.getWater()+"","#D2B48C"));

        try {
            System.out.println("推送成功！");
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }


    }



}
