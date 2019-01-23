package com.kai.chap.found.factory.abstra;

import com.kai.chap.found.factory.AmdCpu;
import com.kai.chap.found.factory.AmdMainBord;
import com.kai.chap.found.factory.Cpu;
import com.kai.chap.found.factory.MainBord;

/**
 * AMD工厂类
 * @author hok
 * @since 2019-1-14 17:22:14
 */
public class AmdFactory implements AbstractFactory {

    public Cpu createCpu() {
        return new AmdCpu(938);
    }

    public MainBord createMainBord() {
        return new AmdMainBord(938);
    }
}
