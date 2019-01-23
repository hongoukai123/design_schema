package com.kai.chap.found.singlet.defer;

/**
 * 延迟初始化保持器单例模式
 * <p>
 *      这个模式综合运用了java的类级内部类和多线程缺省同步锁的知识，
 *      很巧妙的同时实现了延迟加载和线程安全。
 * </p>
 * <p>
 *     什么是类级内部类：
 *     简单说点类级内部类指的是，有static修饰的成员式内部类。如果没有
 *     static修饰的成员式内部类被称为对象级内部类。
 * </p>
 * <p>
 *     类级内部类相当于其外部类的static成分，它的对象与外部类对象不存
 *     在依赖关系，因此可直接创建，而对象级内部类的实例，是绑定在外部
 *     对象实例中的。
 * </p>
 * <p>
 *     类级内部类中，可以定义静态的方法。在静态方法中只能够引用外部类中
 *     的静态成员方法或者成员变量。
 * </p>
 * <p>
 *     类级内部类相当于外部类的成员，只有在第一次被使用的时候才会被装载。
 * </p>
 * @author hok
 * @since 2019-1-22 14:59:47
 */
public class Singleton {

    /**
     * 私有默认构造方法
     */
    private Singleton(){}

    /**
     * 类级的内部类
     * <p>
     *     也就是静态的成员式内部类,该类内部类的实例与外部类的实例没有
     *     绑定关系，而且只有被调用的时候才能被装载，从而实现了延迟加载。
     * </p>
     */
    private static class SingletonHolder{
        //静态初始化器，由JVM来保证线程安全
        private static Singleton singleton = new Singleton();
    }

    /**
     * 静态工厂方法
     * <p>
     *     当此方法被第一次被调用的时候，它第一次读取SingletonHolder.singleton,
     *     导致SingletonHolder得到初始化；而这个类在装载并被初始化的时候，会初始
     *     化它的静态域从而创建Singleton实例，由于是静态的域，因此只会在虚拟机装载
     *     类的时候初始化一次，并由虚拟机来保证它的线程安全行
     * </p>
     * @return
     */
    public static Singleton getInstance(){
        return SingletonHolder.singleton;
    }

}
