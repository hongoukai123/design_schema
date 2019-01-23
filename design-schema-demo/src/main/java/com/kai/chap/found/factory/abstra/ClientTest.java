package com.kai.chap.found.factory.abstra;

/**
 * 测试抽象工厂模式
 * 此抽象工厂模式，处理组装问题，解决了，组装人员只负责组装，
 * 采购配件的时候只需要告诉选择的是Intel还是AMD类型的，
 * 只有这样组装成功后才不会出现不兼容问题
 * @author hok
 * @since 2019-1-14 18:07:43
 */
public class ClientTest {

    public static void main(String[] args){
        ComputerEngineer ce = new ComputerEngineer();
        AbstractFactory af = new IntelFactory();
        ce.makeComputer(af);
    }

}
