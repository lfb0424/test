package locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: LFb
 * @DATE: 2020/8/31 15:43
 */

class MyThread1 extends Thread {
    private Object object;

    public MyThread1(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        System.out.println("before unpark");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
        // 释放许可
        LockSupport.unpark((Thread) object);
        //休眠500ms，保证先执行park中得setBlocker(t,null);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //再次获取Blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));

        System.out.println("after unpark");
    }


}

public class ParkAndUnparkDemo {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1(Thread.currentThread());
        myThread1.start();
        System.out.println("before park");
        //获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }
}
