package org.example;

public class SingletonDemo {
    private static SingletonDemo INSTANCE;

    //private static SingletonDemo INSTANCE=new SingletonDemo();
    private SingletonDemo() {
    }

    public static SingletonDemo getSingleton() {
        return INSTANCE;
    }
}
