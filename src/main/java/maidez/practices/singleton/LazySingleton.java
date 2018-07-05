package maidez.practices.singleton;

/**
 * Created by luwenyi on 2018/6/5.
 */

import java.io.Serializable;

/**
 * 懒汉式
 * volatile关键字防止指令重排
 * PROBLEM: synchronized关键字影响性能
 */
public class LazySingleton implements Serializable {
    private static final long serialVersionUID = 1329709137456459476L;
    private static volatile LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
