package org.fotech.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MyThreadV2 {
    volatile List<Integer> list = new ArrayList<>();
    public void add(int i) {
        list.add(i);
    }

    public int getSize() {
        return list.size();
    }

    // wait notify实现线程2监听线程1数量到5
    public static void main2(String[] args) {
        MyThreadV2 myThreadV2 = new MyThreadV2();
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("T2 start");
                if (myThreadV2.getSize() != 5) {
                    try {
                        lock.wait();
                        System.out.println("T2 end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "T2").start();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("T1 start");
                for(int i = 0; i < 10; i++) {
                    myThreadV2.add(i);
                    System.out.println("add：" + i);
                    if (myThreadV2.getSize() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "T1").start();
    }

    // countlauchdown 实现
    public static void main(String[] args) {
        MyThreadV2 myThreadV2 = new MyThreadV2();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            if (myThreadV2.getSize() != 5) {
                try {
                    System.out.println("T1 wait");
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2 end");
            }
        }, "T2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myThreadV2.add(i);
                System.out.println("add " + i);
                if (myThreadV2.getSize() == 5) {
                    System.out.println("count down");
                    countDownLatch.countDown();
                }
            }
        }, "T1").start();
    }
}
