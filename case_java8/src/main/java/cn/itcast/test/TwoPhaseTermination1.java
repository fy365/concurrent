package cn.itcast.test;

import lombok.extern.slf4j.Slf4j;


@Slf4j(topic = "c.TwoPhaseTermination1")
public class TwoPhaseTermination1 {
    private Thread monitor;

    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                if (current.isInterrupted()) {
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000); // sleep过程中被打断
                    log.debug("执行监控记录"); // 此时被打断
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 重新设置打断标记
                    current.interrupt();
                }
            }
        });
        monitor.start();
    }

    public void stop() {
        monitor.interrupt();
    }
}

@Slf4j(topic = "c.TestTwoPhaseTermination1")
class TestTwoPhaseTermination1 {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();
        Thread.sleep(3500);
        tpt.stop();
    }
}

