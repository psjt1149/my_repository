package com.ps.util;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Water {

    private static List<String> waterList = new ArrayList<>();

    //载入sentences.txt
    static {
        InputStream inputStream = Water.class.getClassLoader().getResourceAsStream("water.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String str = "";
            String temp = "";
            while ((temp = br.readLine()) != null) {
                if (!StringUtils.isEmpty(temp)) {
                    str = str + "\r\n" + temp;
                } else {
                    waterList.add(str);
                    str = "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getWater() {
        Random random = new Random();
        return waterList.get(random.nextInt(waterList.size()));
    }

    public static void main(String[] args) {
        System.out.println(getWater());
    }
}
