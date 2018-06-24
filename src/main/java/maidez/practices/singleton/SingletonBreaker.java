package maidez.practices.singleton;

import maidez.practices.singleton.singletons.HungerSingleton;
import maidez.practices.singleton.singletons.LazySingleton;
import maidez.practices.singleton.singletons.LazySingletonV2;
import maidez.practices.singleton.singletons.LazySingletonV3;
import maidez.practices.singleton.singletons.LazySingletonV4;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by luwenyi on 2018/6/5.
 */

/**
 * 涉及到单例的破坏，每个测试用例单独执行
 */
public class SingletonBreaker {

    @Test
    public void runReflectionBreaker() {
        System.out.println("============================================================================");
        System.out.println("HungerSingleton.class reflectionBreaker result :" + reflectionBreaker(HungerSingleton.class));
        System.out.println("============================================================================");
        System.out.println("LazySingleton.class reflectionBreaker result :" + reflectionBreaker(LazySingleton.class));
        System.out.println("============================================================================");
        System.out.println("LazySingletonV2.class reflectionBreaker result :" + reflectionBreaker(LazySingletonV2.class));
        System.out.println("============================================================================");
        System.out.println("LazySingletonV3.class reflectionBreaker result :" + reflectionBreaker(LazySingletonV3.class));
        System.out.println("============================================================================");
        System.out.println("LazySingletonV4.class reflectionBreaker result :" + reflectionBreaker(LazySingletonV4.class));
        System.out.println("============================================================================");
    }

    @Test
    public void runSerializeBreaker() {
        System.out.println("============================================================================");
        System.out.println("HungerSingleton.class serializeBreaker result :" + serializeBreaker(HungerSingleton.class));
        System.out.println("============================================================================");
        System.out.println("LazySingleton.class serializeBreaker result :" + serializeBreaker(LazySingleton.class));
        System.out.println("============================================================================");
        System.out.println("LazySingletonV2.class serializeBreaker result :" + serializeBreaker(LazySingletonV2.class));
        System.out.println("============================================================================");
        System.out.println("LazySingletonV3.class serializeBreaker result :" + serializeBreaker(LazySingletonV3.class));
        System.out.println("============================================================================");
        System.out.println("LazySingletonV4.class serializeBreaker result :" + serializeBreaker(LazySingletonV4.class));
        System.out.println("============================================================================");
    }

    private static <T> String reflectionBreaker(Class<T> clz) {
        T instance1 = null;
        T instance2 = null;
        try {
            Constructor<T> declaredConstructor = clz.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            instance1 = declaredConstructor.newInstance();
            instance2 = declaredConstructor.newInstance();
        } catch (Exception e) {
            //do nothing
        }

        return checkBreakResult(instance1, instance2) ? "单例被破坏" : "单例未被破坏";

    }

    @SuppressWarnings("unchecked")
    private static <T> String serializeBreaker(Class<T> clz) {
        T instance1 = null;
        T instance2 = null;
        try {
            Method method = clz.getMethod("getInstance");
            instance1 = (T) method.invoke(null);

            ObjectOutput out = null;

            out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instance1);
            out.close();

            //deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            instance2 = (T) in.readObject();
            in.close();
        } catch (Exception e) {
            //do nothing
        }

        return checkBreakResult(instance1, instance2) ? "单例被破坏" : "单例未被破坏";
    }

    private static <T> boolean checkBreakResult(T instance1, T instance2) {
        if (instance1 == null) {
            throw new RuntimeException("CONSTRUCT INSTANCE1 ERROR!!!");
        }
        System.out.println("instance1.hashCode : " + instance1.hashCode());
        if (instance2 == null) {
            System.out.println("instance2 has been forbidden from construct");
            return false;
        } else {
            System.out.println("instance2.hashCode : " + instance2.hashCode());
            return instance1.hashCode() != instance2.hashCode();
        }
    }
}

