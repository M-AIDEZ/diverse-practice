package maidez.practices.singleton.singletons;

import java.io.Serializable;

/**
 * Created by luwenyi on 2018/6/5.
 */
public class LazySingletonV3 implements Serializable {
    private static final long serialVersionUID = 7099980053061521003L;
    private static boolean initialized = false;

    public LazySingletonV3() {
        //在构造方法中进行是否初始化验证，已经初始化再次被执行抛异常
        synchronized (LazySingletonV3.class) {
            if (!initialized) {
                initialized = !initialized;
            } else {
                throw new RuntimeException("Singleton has been initialized!");
            }
        }
    }

    /**
     * 内部类只有在被调用时才会被加载
     */
    private static class LazySingletonHolder {
        private static final LazySingletonV3 instance = new LazySingletonV3();
    }

    public static LazySingletonV3 getInstance() {
        return LazySingletonV3.LazySingletonHolder.instance;
    }

}
