package threadTest.mySynchronize;

/**
 * 同步代码块形式——锁为this,两个线程使用的锁是一样的,线程1必须要等到线程0释放了该锁后，才能执行
 * this锁
 *
 * @author lifubei
 * @date 2020/07/23 14:26
 */
public class SynchronizedObjectLock implements Runnable {

    static SynchronizedObjectLock instance = new SynchronizedObjectLock();

    @Override
    public void run() {
        //同步代码块方式--锁为this，两个线程使用的锁是一样的，线程1必须等待线程0释放锁后，才能执行
        synchronized (this) {
            System.out.println(this);
            System.out.println("我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {
        Thread th0 = new Thread(instance);
        Thread th1 = new Thread(instance);
        th0.start();
        th1.start();
    }
}
