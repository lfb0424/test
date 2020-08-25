package completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 串行执行
 *
 * @author lifubei
 * @date 2020/07/15 11:01
 */
public class ContinueExecute {
    public static void main(String[] args) throws Exception {
        //第一个任务
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
            System.out.println("调用queryCode");
            return queryCode("中国石油");
        });

        //cfQuery 成功后继续执行下一个任务
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
            System.out.println("调用queryPrice，且[code]为:"+code);
            return fetchPrice(code);
        });

        //cfFetch成功后打印结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("如果正确，调用此方法");
            System.out.println("price:" + result);
        });

        cfFetch.exceptionally((e) -> {
            System.out.println("如果失败，调用此方法");
            e.printStackTrace();
            return null;
        });

        Thread.sleep(2000);
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
