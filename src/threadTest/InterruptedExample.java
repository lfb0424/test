package threadTest;

/**
 * @author lifubei
 * @date 2020/07/22 16:49
 */
public class InterruptedExample {
    public static class Thread3 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
                int i = 0;
                System.out.println(i++);
            }
            System.out.println("Thread end");
        }
    }

    public static void main(String[] args) {
        Thread3 thread3 = new Thread3();
        thread3.start();
        thread3.interrupt();
    }
}
