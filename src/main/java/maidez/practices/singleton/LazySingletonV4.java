package maidez.practices.singleton;

/**
 * Created by luwenyi on 2018/6/22.
 */
public class LazySingletonV4 {
    private static final long serialVersionUID = 7099980053061521003L;
    private static boolean initialized = false;

    public LazySingletonV4() {
        synchronized (LazySingletonV4.class) {
            if (!initialized) {
                initialized = !initialized;
            } else {
                throw new RuntimeException("Singleton has been initialized!");
            }
        }
    }

    public static LazySingletonV4 getInstance() {
        return LazySingletonV4.LazySingletonHolder.instance;
    }

    /**
     * readResolve(）代替了从流中读取对象，确保了在序列化和反序列化的过程中没人可以创建新的实例
     */
    private Object readResolve() {
        return getInstance();
    }

    /**
     * 内部类只有在被调用时才会被加载
     */
    private static class LazySingletonHolder {
        private static final LazySingletonV4 instance = new LazySingletonV4();
    }
}
