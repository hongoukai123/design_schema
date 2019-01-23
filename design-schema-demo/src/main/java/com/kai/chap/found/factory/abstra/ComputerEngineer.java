package com.kai.chap.found.factory.abstra;

import com.kai.chap.found.factory.Cpu;
import com.kai.chap.found.factory.MainBord;

/**
 * 装机工程师类
 * @author hok
 * @since 2019-1-14 17:24:26
 */
public class ComputerEngineer {

    /**
     * 组装所需的CPU
     */
    private Cpu cpu = null;

    /**
     * 组装所需的主板
     */
    private MainBord mainBord = null;

    /**
     * 组装电脑
     * @param af
     */
    public void makeComputer(AbstractFactory af){
        //准备组装的产品
        prepareHardwares(af);
    }

    /**
     * 组装电脑
     * @param af
     */
    private void prepareHardwares(AbstractFactory af){
        this.cpu = af.createCpu();
        this.mainBord = af.createMainBord();

        //测试配件是否好用
        this.cpu.calculate();
        this.mainBord.installCPU();
    }

}
