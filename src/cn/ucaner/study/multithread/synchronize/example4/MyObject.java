package cn.ucaner.study.multithread.synchronize.example4;

/**
 * Created by Brian on 2016/4/12.
 */

public class MyObject {
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "  endTime:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized
    public void methodB() {
        try {
            System.out.println("begin methodB threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "  endTime:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
