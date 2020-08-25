package completableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 并行执行——同时从新浪和网易查询证券代码，只要任意一个返回结果，就进行下一步查询价格，查询价格也同时从新浪和网易查询，只要任意一个返回结果，就完成操作
 *
 * @author lifubei
 * @date 2020/07/16 10:47
 */
public class ParallelExecute {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "www.xinlang.com");
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "www.baidu.com");
        });
        //用anyOf合并为一个新的CompletableFuture
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cf1, cf2);


        CompletableFuture<Double> cf3 = cf1.thenApplyAsync((code) -> {
            return fetchPrice(code, "www.xinlang.com");
        });
        CompletableFuture<Double> cf4 = cf2.thenApplyAsync((code) -> {
            return fetchPrice(code, "www.baidu.com");
        });
        //用anyOf合并为一个新的CompleteableFuture
        CompletableFuture<Object> cf = CompletableFuture.anyOf(cf3, cf4);

        //最终结果
        cf.thenAccept((result) -> System.out.println("price:" + result));
        Thread.sleep(200);

    }

    static String queryCode(String name, String url) {
        System.out.println("queryCode from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "6018557";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
