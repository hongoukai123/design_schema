package com.kai.chap.found.factory.abstra;

import com.kai.chap.found.factory.Cpu;
import com.kai.chap.found.factory.IntelCpu;
import com.kai.chap.found.factory.IntelMainBord;
import com.kai.chap.found.factory.MainBord;

/**
 * Intel工厂类
 * @author hok
 * @since 2019-1-14 17:19:46
 */
public class IntelFactory implements AbstractFactory {

    public Cpu createCpu() {
        return new IntelCpu(755);
    }

    public MainBord createMainBord() {
        return new IntelMainBord(755);
    }
}
