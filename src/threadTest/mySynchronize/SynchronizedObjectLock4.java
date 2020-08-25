package threadTest.mySynchronize;

/**
 * @author lifubei
 * @date 2020/07/23 14:52
 * <p>
 * 用在普通方法上
 */
public class SynchronizedObjectLock4 implements Runnable {

    static SynchronizedObjectLock4 instance1 = new SynchronizedObjectLock4();
    static SynchronizedObjectLock4 instance2 = new SynchronizedObjectLock4();

    @Override
    public void run() {
        method();
    }

    // synchronized用在普通方法上，默认的锁就是this，当前实例
    private synchronized void method() {
        System.out.println("我是线程" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }


    public static void main(String[] args) {
        Thread th1 = new Thread(instance1);
        Thread th2 = new Thread(instance2);
        th1.start();
        th2.start();
    }
}
