package com.ps.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MemorableDay {
    // 恋爱
    static String inLove = "2020-10-05";
    // 生日-女
    static String birthdayOfGirl = "1999-04-21";
    // 生日-男
    static String birthdayOfBoy = "2000-07-28";

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");

    /**
     * 距离date还有多少天
     *
     * @param date
     * @return
     */
    public static int before(String date) {
        int day = 0;
        try {
            long time = simpleDateFormat.parse(date).getTime() - System.currentTimeMillis();
            day = (int) (time / 86400000L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }


    /**
     * 已经过去date多少天
     *
     * @param date
     * @return
     */
    public static int after(String date) {
        int day = 0;
        try {
            long time = System.currentTimeMillis() - simpleDateFormat.parse(date).getTime();
            day = (int) (time / 86400000L);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }


    public static int getBirthDay(String addtime) {
        int days = 0;
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            String clidate = addtime;
            Calendar cToday = Calendar.getInstance(); // 存今天
            Calendar cBirth = Calendar.getInstance(); // 存生日
            cBirth.setTime(myFormatter.parse(clidate)); // 设置生日
            cBirth.set(Calendar.YEAR, cToday.get(Calendar.YEAR)); // 修改为本年
            if (cBirth.get(Calendar.DAY_OF_YEAR) < cToday.get(Calendar.DAY_OF_YEAR)) {
                // 生日已经过了，要算明年的了
                days = cToday.getActualMaximum(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
                days += cBirth.get(Calendar.DAY_OF_YEAR);
            } else {
                // 生日还没过
                days = cBirth.get(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }


    public static int getInLove() {
        return after(inLove);
    }

    public static int getBirthdayOfGirl() {
        return getBirthDay(birthdayOfGirl);
    }

    public static int getBirthdayOfBoy() {
        return getBirthDay(birthdayOfBoy);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(simpleDateFormat.parse(birthdayOfBoy));
    }


}
