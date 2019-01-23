package com.kai.chap.found.factory.common;

import com.kai.chap.found.factory.AmdCpu;
import com.kai.chap.found.factory.Cpu;
import com.kai.chap.found.factory.IntelCpu;

/**
 * CPU工厂类
 * @author hok
 * @since 2019-1-14 16:31:44
 */
public class CpuFactory {

    public static Cpu createCpu(int type){
        Cpu cpu = null;
        if(type == 1){
            cpu = new IntelCpu(755);
        }else if (type == 2){
            cpu = new AmdCpu(938);
        }
        return cpu;
    }

}
