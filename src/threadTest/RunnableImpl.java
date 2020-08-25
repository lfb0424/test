package threadTest;

/**
 * @author lifubei
 * @date 2020/07/22 15:37
 */
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("使用线程的方式之一：实现runnable接口。RunnableImpl这个类只能当作一个可以在线程中运行的任务 不是真正意义的线程");
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableImpl instance = new RunnableImpl();
        Thread thread = new Thread(instance);
        thread.start();
    }
}
