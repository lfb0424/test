package locksupport;

/**
 * @Author: LFb
 * @DATE: 2020/8/31 15:23
 */
public class WaitAndNotifyDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        synchronized (myThread) {
            try {
                myThread.start();
                Thread.sleep(3000);
                System.out.println("before wait...");
                myThread.wait();
                System.out.println("after wait...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("before notify");
            notify();
            System.out.println("after notify");
        }
    }
}
