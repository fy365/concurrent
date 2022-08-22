package cn.itcast.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test12")
public class Thread_Interrupt3 {

    public static void main(String[] args) throws InterruptedException {

        // 正常运行的线程，被打断了不会退出，他的打断标记会为true
        // 可以根据打断标记判断，去执行用户想要的操作(比如一些善后操作),然后优雅的退出
        Thread t1 = new Thread(() -> {
            while(true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if(interrupted) {
                    log.debug("被打断了, 退出循环");
                    break;
                }
            }
        }, "t1");
        t1.start();

        Thread.sleep(1000);
        log.debug("interrupt");
        t1.interrupt();
    }
}
