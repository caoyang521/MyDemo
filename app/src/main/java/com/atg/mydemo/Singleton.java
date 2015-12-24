package com.atg.mydemo;

/**
 * Created by Mr_TT on 2015/12/24 0024.
 */

/**
 * Double CheckLock ( DCL )实现单例
 * CL方式实现单例模式的优点是既能够在需要时才初始化单例，又能够保证线程安全，
 * 且单例对象初始化后调用getInstance不进行同步锁。
 *
 */

/*
    本程序的亮点自然都在getInstance方法上，可以看到getInstance方法中对instance进行了两次判空：第一层判断主要是为了避免不必要的同步，
    第二层的判断则是为了在null的情况下创建实例。

    DCL优点：资源利用率高，第一次执行getInstance时单例对象才会被实例化
       缺点：第一次加载时反映稍慢，也由于Java内存模型的原因偶尔会失败。
 */
/*public class Singleton {
    private static Singleton sInstance = null;
    private Singleton(){}
    public void doSomething(){
        System.out.println("do sth");
    }
    public static Singleton getInstance(){
        if(mInstance==null){
            synchronized (Singleton.class){
                if(mInstance==null){
                    sInstance=new Singleton();
                }
            }
        }
        return sInstance;
    }
}*/

/**
 * 静态内部类单例模式
 * DCL虽然在一定程度上解决了资源消耗、多余的同步、线程安全等问题，但是，它还是在
 * 某些情况下失效的问题。这个问题被称为双重检查锁定(DCL)失效
 *
 * 当第一次加载Singleton类时并不会初始化sInstance,只有在第一次调用Singleton的
 * getInstance方法时蔡慧导致sInstance被初始化。因此，第一次调用getInstance方法
 * 会导致虚拟机加载SingletonHolder类，这种方式不仅能够确保线程安全，也能够保证单例
 * 对象的唯一性。同时也延迟了单例的实例化，所以这是推荐使用的单例模式实现方式。
 */
public class Singleton{
    private Singleton(){}
    public static Singleton getInstance(){
        return SingletonHolder.sInstance;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        public static final Singleton sInstance=new Singleton();
    }
}






/*
//普通方法
public class Singleton {
    private Singleton() {
    }

    public static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
*/

/*
public class Singleton2 {
    private static Singleton2 instance2 = null;

    public static synchronized Singleton2 getINstance() {
        if (instance2 == null) {
            instance2 = new Singleton2();
        }
        return instance2;
    }
}
*/

