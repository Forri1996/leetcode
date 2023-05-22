package org.fotech.leetcode;

import java.util.concurrent.CountDownLatch;

public class MyThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.exec();
    }


    public void exec() {
        try {
            CountDownLatch latch = new CountDownLatch(1);
            Thread t1 = new Thread(new AThread(latch), "T1");
            t1.start();
            latch.await();
            Thread t2 = new Thread(new AThread(latch), "T2");
            t2.start();
            latch.await();
            Thread t3 = new Thread(new AThread(latch), "T3");
            t3.start();
            latch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class AThread implements Runnable {
        private CountDownLatch latch;

        AThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }
}
