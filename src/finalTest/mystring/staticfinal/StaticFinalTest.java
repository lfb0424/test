package finalTest.mystring.staticfinal;

import java.util.Random;

/**
 * @Author: LFb
 * @DATE: 2020/8/18 15:02
 */
public class StaticFinalTest {
    static Random r = new Random();
    final int k = r.nextInt(10);
    static final int k2 = r.nextInt(10);

    public static void main(String[] args) {
        StaticFinalTest s1 = new StaticFinalTest();
        System.out.println("k="+s1.k+",k2="+ k2);
    }
}
