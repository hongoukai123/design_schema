package com.kai.chap.found.factory;

/**
 * AMD的CPU接口实现类
 * @author hok
 * @since 2019-1-14 16:33:25
 */
public class AmdCpu implements Cpu {

    /**
     * cup针脚数
     */
    private int pins = 0;

    /**
     * 构造方法，传入CPU针脚数
     * @param pins
     */
    public AmdCpu(int pins){
        this.pins = pins;
    }

    public void calculate() {
        System.out.println("AMD CPU针脚数为：" + pins);
    }

}
