package threadTest.mySynchronize;

/**
 * 这个代码块使用的是第一把锁，当他释放后，后面的代码块由于使用的是第二把锁，因此可以马上执行
 * 自定义的锁
 *
 * @author lifubei
 * @date 2020/07/23 14:38
 */
public class SynchronizedObjectLock2 implements Runnable {

    static SynchronizedObjectLock2 instance = new SynchronizedObjectLock2();

    //创建两把锁
    Object block1 = new Object();
    Object block2 = new Object();

    @Override
    public void run() {
        // 这个代码块使用的是第一把锁，当他释放后，后面的代码块由于使用的是第二把锁，因此可以马上执行
        synchronized (block1) {
            System.out.println("block1锁，我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("block1锁，" + Thread.currentThread().getName() + "结束了");
        }
        synchronized (block2) {
            System.out.println("block2锁，我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("block2锁，" + Thread.currentThread().getName() + "结束了");
        }
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(instance);
        Thread th2 = new Thread(instance);

        th1.start();
        th2.start();
    }
}
