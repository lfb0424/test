package threadTest.myVolatile;

/**
 * @author lifubei
 * @date 2020/07/23 17:54
 */
public class Singleton {
    public static volatile Singleton singleton;

    /**
     * 构造器私有化，禁止外部实例化
     */
    private Singleton() {
    }

    ;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


    /**
     * 实例化对象步骤：
     * 1、分配空间
     * 2、初始化对象
     * 3、将内存空间的地址赋值给对应的引用
     */
}
