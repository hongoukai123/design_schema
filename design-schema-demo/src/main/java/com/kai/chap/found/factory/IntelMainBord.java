package com.kai.chap.found.factory;

/**
 * Intel主板接口实现类
 * @author hok
 * @since 2019-1-14 16:28:55
 */
public class IntelMainBord implements MainBord {

    /**
     * cpu插槽孔数
     */
    private int cpuHoles = 0;

    /**
     * 构造方法，传入CPU插槽孔数
     * @param cpuHoles
     */
    public IntelMainBord(int cpuHoles){
        this.cpuHoles = cpuHoles;
    }

    /**
     *
     */
    public void installCPU() {
        System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);
    }

}
