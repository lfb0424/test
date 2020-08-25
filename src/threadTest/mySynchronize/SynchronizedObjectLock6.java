package threadTest.mySynchronize;

/**
 * synchronized指定锁对象为Class对象
 * 所有线程需要的锁都是同一把
 *
 * @author lifubei
 * @date 2020/07/23 15:01
 */
public class SynchronizedObjectLock6 implements Runnable {
    static SynchronizedObjectLock6 instance1 = new SynchronizedObjectLock6();
    static SynchronizedObjectLock6 instance2 = new SynchronizedObjectLock6();

    @Override
    public void run() {
        // 所有线程需要的锁都是同一把
        synchronized (SynchronizedObjectLock6.class) {
            System.out.println("我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束了");
        }
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(instance1);
        Thread th2 = new Thread(instance2);
        th1.start();
        th2.start();
    }
}
