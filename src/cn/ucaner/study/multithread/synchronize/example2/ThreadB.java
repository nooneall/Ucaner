package cn.ucaner.study.multithread.synchronize.example2;

/**
 * Created by Brian on 2016/4/11.
 */
public class ThreadB extends Thread {
    private HasSelfPrivateNum numRef;

    public ThreadB(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
