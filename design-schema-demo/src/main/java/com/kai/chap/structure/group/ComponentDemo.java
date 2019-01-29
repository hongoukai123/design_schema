package com.kai.chap.structure.group;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * <p>
 *     例子：首先，一张卡可以在总部、分店、加盟店使用，那么总部可以刷卡，分店也可以刷卡，
 *          加盟店也可以刷卡，这个属性结构的店面层级关系就明确了。
 *              那么总店刷卡消费与分店刷卡消费是一样的道理，那么总店与分店对会员卡的使
 *          用也具有一致性。
 * </p>
 * @author hok
 * @since 2019-1-25 10:52:46
 */
public class ComponentDemo {

    public abstract class Component{

        String name;

        public abstract void add(Component c);

        public abstract void remove(Component c);

        public abstract void eachChild();
    }

    /**
     * 组合部件类
     */
    public class Leaf extends Component{

        public void add(Component c) {
            System.out.println(" ");
        }

        public void remove(Component c) {
            System.out.println(" ");
        }

        public void eachChild() {
            System.out.println(name + "执行了");
        }
    }

    /**
     * 组合类
     */
    public class Composite extends Component{
        //用来保存节点的子节点
        List<Component> list = new ArrayList<Component>();

        //添加节点添加部件
        public void add(Component c) {
            list.add(c);
        }

        //删除节点删除部件
        public void remove(Component c) {
            list.remove(c);
        }

        //遍历子节点
        public void eachChild() {
            System.out.println(name + "执行了");
            for (Component c : list){
                c.eachChild();
            }
        }
    }

    public static void main(String[] args){
        ComponentDemo comp = new ComponentDemo();
        Composite composite = comp.new Composite();
        composite.name = "根节点";

        Composite compositeLeft = comp.new Composite();
        compositeLeft.name = "左节点";

        Composite compositeRight = comp.new Composite();
        compositeRight.name = "右节点";

        Leaf leaf = comp.new Leaf();
        leaf.name = "右-子节点1";
        Leaf leaf1 = comp.new Leaf();
        leaf1.name = "右-子节点2";
        compositeRight.add(leaf);
        compositeRight.add(leaf1);

        composite.add(compositeRight);
        composite.add(compositeLeft);

        composite.eachChild();
    }


}
