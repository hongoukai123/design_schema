package com.kai.chap.found.factory.common;

import com.kai.chap.found.factory.Cpu;
import com.kai.chap.found.factory.MainBord;

/**
 * 装机工程师类
 * @author hok
 * @since 2019-1-14 16:39:40
 */
public class ComputerEngineer {

    /**
     * 定义装机所需CPU
     */
    private Cpu cpu = null;

    /**
     * 定义装机所需主板
     */
    private MainBord mainBord = null;

    /**
     * 组装电脑
     * @param cpuType CPU类型
     * @param mainBordType 主板类型
     */
    public void makeComputer(int cpuType, int mainBordType){
        //准备组装所需配件
        prepareHardwares(cpuType, mainBordType);
    }

    /**
     * 开始组装
     * @param cpuType CPU类型
     * @param mainBordType 主板类型
     */
    private void prepareHardwares(int cpuType, int mainBordType){
        this.cpu = CpuFactory.createCpu(cpuType);
        this.mainBord = MainBordFactory.createMainBord(mainBordType);
        //测试配件是否好用
        this.cpu.calculate();
        this.mainBord.installCPU();
    }


}
