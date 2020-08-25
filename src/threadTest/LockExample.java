package threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lifubei
 * @date 2020/07/22 17:17
 */
public class LockExample {

    private Lock lock = new ReentrantLock();

    public void func1() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        } finally {
            //todo 确保释放锁，从而避免发生死锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(lockExample::func1);
        executorService.execute(lockExample::func1);
    }
}
