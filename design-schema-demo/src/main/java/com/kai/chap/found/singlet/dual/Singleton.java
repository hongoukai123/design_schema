package com.kai.chap.found.singlet.dual;

/**
 * 双重检查加锁懒汉式单例模式
 * <p>
 *      所谓“双重检查加锁”机制，指的是并不是每次进入getInstance方法都需要
 *      同步，而是先不同步，进入方法后，先检查实例是否存在，如果不存在才进
 *      行下面的同步块，这是第一重检查，进入同步块后，再次检查实例是否存在，
 *      如果不存在，就在同步的情况下创建一个实例，这是第二重检查。这样一来就
 *      只需要同步一次了，从而减少了多次在同步情况下进行判断所浪费的时间。
 * </p>
 * <p>
 *     这种实现方式既可以实现线程安全地创建实例，而又不会对性能造成太大的影响，
 *     它只是第一次创建实例的时候同步，以后就不需要同步了，从而加快了运行速度。
 * </p>
 * @author hok
 * @since 2019-1-22 10:50:00
 */
public class Singleton {

    /**
     * 定义私有空对象
     * <p>
     *     使用关键字volatile,它的意思是：被volatile关键字修饰过的变量的值，
     *     将不会被本地线程缓存，所有对象变量的读写，都是直接操作共享内存，从
     *     而确保多个线程能正确的处理该变量。
     * </p>
     */
    private static volatile Singleton singleton = null;

    /**
     * 私有默认构造方法
     */
    private Singleton(){}

    /**
     * 静态工厂方法
     * @return
     */
    private static Singleton getInstance(){
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if(singleton == null){
            //同步块，线程安全的创建实例
            synchronized(Singleton.class){
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
