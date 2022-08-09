package com.ps.util;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sentences {

    private static List<String> sentencesList = new ArrayList<>();

    //载入sentences.txt
    static {
        InputStream inputStream = Sentences.class.getClassLoader().getResourceAsStream("sentences.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String str = "";
            String temp = "";
            while ((temp = br.readLine()) != null) {
                if (!StringUtils.isEmpty(temp)) {
                    str = str + "\r\n" + temp;
                } else {
                    sentencesList.add(str);
                    str = "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getSentences() {
        Random random = new Random();
        return sentencesList.get(random.nextInt(sentencesList.size()));
    }

    public static void main(String[] args) {
        System.out.println(getSentences());
    }
}
