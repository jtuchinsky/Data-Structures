package com.wellsfargo.interview;

public class Singleton {
    private volatile static Singleton INSTANCE = null;

    public static Singleton getInstance(){

        synchronized (Singleton.class) {
            if(INSTANCE == null){
                synchronized (Singleton.class) {
                    INSTANCE = new Singleton();
                }
            }
            return INSTANCE;
        }
    }

    private Singleton(){

    }
}
