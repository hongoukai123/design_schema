package com.kai.chap.found.factory.abstra;

import com.kai.chap.found.factory.Cpu;
import com.kai.chap.found.factory.MainBord;

/**
 * 抽象工厂类
 * @author hok
 * @since 2019-1-14 17:16:38
 */
public interface AbstractFactory {

    /**
     * 创建Cpu对象
     * @return
     */
    public Cpu createCpu();

    /**
     * 创建主板对象
     * @return
     */
    public MainBord createMainBord();

}
