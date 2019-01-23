package com.kai.chap.found.factory;

/**
 * Intel的CPU接口实现类
 * @author hok
 * @since 2019-1-14 16:30:43
 */
public class IntelCpu implements Cpu {

    /**
     * cpu针脚数
     */
    private int pins = 0;

    /**
     * 构造方法，传入CPU针脚数
     * @param pins
     */
    public IntelCpu(int pins){
        this.pins = pins;
    }

    public void calculate() {
        System.out.println("Intel CPU的针脚数为：" + pins);
    }

}
