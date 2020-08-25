package threadTest;

/**
 * @author lifubei
 * @date 2020/07/22 16:13
 */
public class InterruptExample {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        thread1.start();
        thread1.interrupt();
        System.out.println("Main run");
    }
}


