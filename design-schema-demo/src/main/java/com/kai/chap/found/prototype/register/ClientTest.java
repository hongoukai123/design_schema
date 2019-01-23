package com.kai.chap.found.prototype.register;

/**
 * 客户端角色测试类
 * @author hok
 * @since 2019-1-16 17:09:32
 */
public class ClientTest {

    public static void main(String[] args){
        try {
            Prototype p1 = new ConcretePrototype1();
            PrototypeManager.setPrototype("p1", p1);
            //获取原型来创建对象
            Prototype p3 = PrototypeManager.getPrototype("p1").clone();
            p3.setName("张三");
            System.out.println("第一个实例：" + p3);
            //有人动态的切换了实现
            Prototype p2 = new ConcretePrototype2();
            PrototypeManager.setPrototype("p2", p2);
            //重新获取原型来创建对象
            Prototype p4 = PrototypeManager.getPrototype("p2").clone();
            p4.setName("李四");
            System.out.println("第二个实例：" + p4);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
