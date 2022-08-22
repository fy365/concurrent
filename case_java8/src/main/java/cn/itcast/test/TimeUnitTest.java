package cn.itcast.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test8")
public class TimeUnitTest {

    public static void main(String[] args) throws InterruptedException {
        log.debug("enter");
        java.util.concurrent.TimeUnit.SECONDS.sleep(1);
        log.debug("end");
//        Thread.sleep(1000);
    }
}
