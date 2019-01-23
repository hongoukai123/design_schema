package com.kai.chap.found.factory.common;

/**
 * 测试普通工厂模式
 * @author hok
 * @since 2019-1-14 16:57:54
 */
public class ClientTest {

    public static void main(String[] args){
        ComputerEngineer ce = new ComputerEngineer();
        ce.makeComputer(1,1);
    }

}
