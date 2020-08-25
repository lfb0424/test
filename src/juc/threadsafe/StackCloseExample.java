package juc.threadsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 不需要同步线程就安全
 * <p>
 * 栈封闭
 *
 * @Author: LFb
 * @DATE: 2020/8/25 17:03
 */
public class StackCloseExample {

    public void add100() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        StackCloseExample example = new StackCloseExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(example::add100);
        executorService.execute(example::add100);
        executorService.shutdown();
    }
}
