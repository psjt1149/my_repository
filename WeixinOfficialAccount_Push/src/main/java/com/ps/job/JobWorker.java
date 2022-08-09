package com.ps.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.ps.util.Pusher;


@Component
public class JobWorker {
    //要推送的用户openid
    private static String pp = "ozoSs6Ycmv0TAKeDTNbZQLhyzUvY";
    private static String tt = "ozoSs6ShO86kplNJMj0WswsbGHc8";

    @Scheduled(cron = "0 0 9 * * ?")
    public void goodMorning(){
        Pusher.push(pp);
        Pusher.push(tt);
    }

    @Scheduled(cron = "0 0 11,15 * * ?")
    public void pushWater(){
        Pusher.water(pp);
        Pusher.water(tt);
    }

}
