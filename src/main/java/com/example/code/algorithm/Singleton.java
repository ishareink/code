package com.example.code.algorithm;

/**
 * DCL 单例
 */
public class Singleton {
    public volatile static Singleton singleton=null;
    public static Singleton getSingleton(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
