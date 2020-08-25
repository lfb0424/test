package threadTest.myVolatile;

/**
 * @author lifubei
 * @date 2020/07/24 16:00
 */
public class VolatileTest01 {
    volatile int i;

    public void addI() {
        synchronized (this){
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest01 test = new VolatileTest01();
        for (int n = 0; n < 1000; n++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.addI();
                }
            }).start();
        }
        Thread.sleep(10000);
        System.out.println(test.i);
    }
}
