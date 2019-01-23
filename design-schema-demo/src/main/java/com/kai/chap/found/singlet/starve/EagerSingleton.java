package com.kai.chap.found.singlet.starve;

/**
 * <p>饿汉式单例模式</p>
 * <p>
 *     单例类只能有一个实例。
 *     单例类必须自己创建自己的唯一实例。
 *     单例类必须给所有其他对象提供这一实例。
 * </p>
 * <p>
 *     在这个类被加载时，静态变量instance会被初始化，
 *     此时类的私有构造方法会被调用，这时候，单例的唯一
 *     实例就被创建出来了。
 * </p>
 * <p>
 *     饿汉式是一种比较形象的称谓，既然饿，那么在创建对
 *     象实例的时候就比较着急，饿了嘛，于是在装载类的时
 *     候就创建对象实例。
 * </p>
 * <p>
 *     饿汉式是典型的空间换时间，当类装载的时候就会创建
 *     类的实例，不管你用不用，先创建出来，然后每次调用
 *     的时候，就不用在判断，节省了运行时间。
 * </p>
 * @author hok
 * @since 2019-1-22 10:05:48
 */
public class EagerSingleton {

    //创建私有化对象实例
    private static EagerSingleton eagerSingleton = new EagerSingleton();

    /**
     * 创建私有构造方法
     */
    private EagerSingleton(){}

    /**
     * 静态工厂方法
     * @return
     */
    public static EagerSingleton getInstance(){
        return eagerSingleton;
    }

}
