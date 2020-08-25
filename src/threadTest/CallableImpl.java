package threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 与Runnable相比，Callable可以有返回值，返回值通过FutureTask进行封装
 *
 * @author lifubei
 * @date 2020/07/22 15:42
 */
public class CallableImpl implements Callable<Integer> {

    @Override
    public Integer call(){
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableImpl callableImpl = new CallableImpl();
        FutureTask<Integer> futureTask = new FutureTask<>(callableImpl);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
