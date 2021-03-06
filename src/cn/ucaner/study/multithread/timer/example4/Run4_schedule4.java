package cn.ucaner.study.multithread.timer.example4;

/**
 * Created by brian on 2016/4/15.
 */

import java.util.Timer;
import java.util.TimerTask;

/**
 * P255
 * schedule(TimerTask task, long delay, long period)方法
 * long类型
 * 不延时的情况下，若执行任务未被延时，第一次执行是任务开始+delay，下次执行任务的开始时间是上一次任务的开始时间加上period
 */
public class Run4_schedule4 {
    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            try {
                System.out.println("begin timer=" + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("end   timer=" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        System.out.println("当前时间：" + System.currentTimeMillis());
        Timer timer = new Timer();
        timer.schedule(task, 3000, 4000);
    }
}

/*
输出：
当前时间：1460736721660
begin timer=1460736724662
end   timer=1460736725662
begin timer=1460736728662
end   timer=1460736729662
begin timer=1460736732662
end   timer=1460736733662
begin timer=1460736736662
end   timer=1460736737662

 */