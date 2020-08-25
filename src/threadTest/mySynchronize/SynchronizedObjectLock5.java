package threadTest.mySynchronize;

/**
 * @author lifubei
 * @date 2020/07/23 14:59
 * <p>
 * 用在静态方法上
 */
public class SynchronizedObjectLock5 implements Runnable {

    static SynchronizedObjectLock5 instance1 = new SynchronizedObjectLock5();
    static SynchronizedObjectLock5 instance2 = new SynchronizedObjectLock5();

    @Override
    public void run() {
        staticMethod();
    }

    // synchronized用在静态方法上，默认的锁就是当前所在的Class类，所以无论是哪个线程访问它，需要的锁都只有一把
    private static synchronized void staticMethod() {
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
