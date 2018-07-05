package maidez.practices.singleton;

/**
 * Created by luwenyi on 2018/6/5.
 */

import java.io.Serializable;

/**
 * 懒汉式 —— 静态内部类方式
 */
public class LazySingletonV2 implements Serializable {
    private static final long serialVersionUID = -5670169964288167051L;

    private LazySingletonV2() {
    }

    /**
     * 内部类只有在被调用时才会被加载
     */
    private static class LazySingletonHolder {
        private static final LazySingletonV2 instance = new LazySingletonV2();
    }

    public static LazySingletonV2 getInstance() {
        return LazySingletonHolder.instance;
    }
}
