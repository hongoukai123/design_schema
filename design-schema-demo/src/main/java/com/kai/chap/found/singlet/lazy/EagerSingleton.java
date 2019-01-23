package com.kai.chap.found.singlet.lazy;

/**
 * 懒汉式单例模式
 * <p>
 *     单例类只能有一个实例。
 *     单例类必须自己创建自己的唯一实例。
 *     单例类必须给所有其他对象提供实例。
 * </p>
 * <p>
 *      懒汉式其实是一种比较形象的称谓。
 *      既然懒，那么在创建对象实例的时候就不着急。
 *      会一直等到马上要使用对象实例的时候才会创建。
 *      懒人嘛，总是推脱不开的时候才会真正去执行工作，
 *      因此在装载对象的时候不创建对象实例。
 * </p>
 * @author hok
 * @since 2019-1-22 10:34:21
 */
public class EagerSingleton {

    /**
     * 定义空的对象
     */
    private static EagerSingleton eagerSingleton = null;

    /**
     * 私有默认构造方法
     */
    private EagerSingleton(){}

    /**
     * 静态工厂方法
     * <p>
     *     静态工厂方法使用了同步化，以处理多线程环境。
     * </p>
     * @return
     */
    private static synchronized EagerSingleton getInstance(){
        if (eagerSingleton == null){
            eagerSingleton = new EagerSingleton();
        }
        return eagerSingleton;
    }

}
