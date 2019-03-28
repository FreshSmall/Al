package com.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static long start;

    private static CyclicBarrier cycliBarrier = new CyclicBarrier(1, new Runnable() {
        @Override
        public void run() {
            System.out.println("线程执行完毕，开始查看修改值：" + i);

            System.out.println(System.currentTimeMillis() - start + "ms");

        }
    });


    private static ReentrantLock lock = new ReentrantLock();
//	private static MyselfLock lock = new MyselfLock();

    private static int i = 0;

    public static void increntValue() {
        i++;
    }

    static class IncrementVauleThread implements Runnable {

        @Override
        public void run() {

            System.out.println("线程" + Thread.currentThread().getName() + "的计数器：" + lock.getHoldCount());
            lock.lock();
            System.out.println("线程：" + Thread.currentThread().getName() + "队列长度：" + lock.getQueueLength());
            for (int i = 0; i < 1000; i++) {
                increntValue();
            }
            lock.unlock();

            try {
                cycliBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    static class Emplyee1Thread implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("线程开始休眠");
//				Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        /*start = System.currentTimeMillis();

        for (int i = 0; i < 3; i++) {
            new Thread(new IncrementVauleThread()).start();
        }*/

        System.out.println(Thread.interrupted());
    }
}
