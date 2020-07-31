package maidez.practices.concurrent.CustomAtomicInteger;

import lombok.Getter;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyAtomicInteger {
    private static class AtomicInteger {
        @Getter
        private volatile int value;

        private static Unsafe unsafe;

        private static long valueoffset;

        static {
            try {
                Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                unsafe = (Unsafe) theUnsafe.get(null);
                Field value = MyAtomicInteger.AtomicInteger.class.getDeclaredField("value");
                valueoffset = unsafe.objectFieldOffset(value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }


        public int increase() {
            for (; ; ) {
                int prev = unsafe.getIntVolatile(this, valueoffset);
                if (unsafe.compareAndSwapInt(this, valueoffset, prev, prev + 1))
                    return prev + 1;
            }
        }
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            executorService.submit(atomicInteger::increase);
        }
        executorService.shutdown();
        System.out.println(atomicInteger.value);
    }
}
