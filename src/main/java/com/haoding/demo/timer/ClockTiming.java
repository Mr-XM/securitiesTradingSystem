package com.haoding.demo.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClockTiming {

    //@Scheduled(cron="0/3 26 7-8 * * ?")
    public void insertClock(){
        System.out.println("1234");
    }

}
