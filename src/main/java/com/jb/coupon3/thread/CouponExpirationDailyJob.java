package com.jb.coupon3.thread;

import com.jb.coupon3.repositories.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@EnableAsync
public class CouponExpirationDailyJob {
    @Autowired
    private CouponRepo couponRepo;

    @Scheduled(cron = "0 0 2 * * ?")
    public void deleteByDate(){
        System.out.println("im start");
        couponRepo.deleteCouponsByDate();
    }
}

