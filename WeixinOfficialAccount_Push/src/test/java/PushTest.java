import org.junit.Test;

import com.ps.util.HttpUtil;
import com.ps.util.Pusher;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class PushTest {

    //测试推送
    @Test
    public void goodMorning() {
        Pusher.push("ozoSs6Ycmv0TAKeDTNbZQLhyzUvY");    //自己
        //Pusher.push("ozoSs6ShO86kplNJMj0WswsbGHc8");
    }

    @Test
    public void pushWater() {
        Pusher.water("ozoSs6Ycmv0TAKeDTNbZQLhyzUvY");    //自己
        //Pusher.water("ozoSs6ShO86kplNJMj0WswsbGHc8");
    }


    //获取数据
    @Test
    public void getWeatherPage() throws IOException {
        URL url = new URL("http://flash.weather.com.cn/wmaps/xml/shenzhen.xml");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String text = br.readLine();
        String text2 = br.readLine();
        String text3 = br.readLine();
        System.out.println(text);
        System.out.println(text2);
        System.out.println(text3);
        br.close();
    }


    @Test
    public void captureHtml() throws Exception {
        String strURL = "http://flash.weather.com.cn/wmaps/xml/shenzhen.xml";

        URL url = new URL(strURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
        BufferedReader bufReader = new BufferedReader(input);
        String line = "";
        StringBuilder contentBuf = new StringBuilder();
        while ((line = bufReader.readLine()) != null) {
            contentBuf.append(line);
        }

        String buf = contentBuf.toString();
        int beginIx1 = buf.indexOf("tem1");
        int endIx1 = buf.indexOf("tem2");

        int beginIx2 = buf.indexOf("tem2");
        int endIx2 = buf.indexOf("temNow");

        String result1 = buf.substring(beginIx1, endIx1);
        String result2 = buf.substring(beginIx2, endIx2);

        System.out.println("温度：\n" + result1 + "\n" + result2);

        String maxTem = result1.substring(6, result1.length() - 2) + "℃";
        String minTem = result2.substring(6, result1.length() - 2) + "℃";
        System.out.println("最高温度：" + maxTem);
        System.out.println("最低温度：" + minTem);


    }


    @Test
    public void getDate() {
        Date date = new Date();
        System.out.println(date);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(new Date()));

        SimpleDateFormat today = new SimpleDateFormat("yyyy年MM月dd日 E");
        System.out.println(today.format(new Date()));


    }


    @Test
    public void dayTest(){

        Calendar calendar = Calendar.getInstance();
        //获取当前日期在一年中是第几天
        int nowDay = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(nowDay);


    }


}
