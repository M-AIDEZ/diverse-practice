package maidez.practices.singleton;

/**
 * Created by luwenyi on 2018/6/5.
 */

import java.io.Serializable;

/**
 * 饿汉式
 * PROBLEM：占用空间
 */
public class HungerSingleton implements Serializable {
    private static final HungerSingleton instance = new HungerSingleton();
    private static final long serialVersionUID = -5692004792080466759L;

    private HungerSingleton() {
    }

    public static HungerSingleton getInstance() {
        return instance;
    }
}
