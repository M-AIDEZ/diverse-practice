package maidez.practices.classloader;

public class ClassLoaderPractice {

    public static void main(String[] args) throws ClassNotFoundException {
//        InnerClass.i++;

        Class<?> innerClass1 = Class.forName("maidez.practices.classloader.ClassLoaderPractice$InnerClass");
//        Class<?> innerClass1 = Class.forName("java.lang.Thread");
        System.out.println(InnerClass.i);
    }

    public static class InnerClass {
        static int i;

        static {
            System.out.println("InnerClass static block");
        }
    }
}
