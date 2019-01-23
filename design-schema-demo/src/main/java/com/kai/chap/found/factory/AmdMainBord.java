package com.kai.chap.found.factory;

/**
 * AMD主板接口实现类
 * @author hok
 * @since 2019-1-14 16:32:34
 */
public class AmdMainBord  implements MainBord {

    /**
     * cpu插槽孔数
     */
    private int cpuHoles = 0;

    /**
     * 构造方法，传入cpu插槽孔数
     * @param cpuHoles
     */
    public AmdMainBord(int cpuHoles){
        this.cpuHoles = cpuHoles;
    }

    public void installCPU() {
        System.out.println("CMD主板的CPU插槽孔数是：" + cpuHoles);
    }

}
