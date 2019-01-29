package com.kai.chap.structure.group;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用组合模式
 * @author hok
 * @since 2019-1-25 10:57:52
 */
public class PayDemo {

    public abstract class Market{
        String name;

        public abstract void add(Market m);

        public abstract void remove(Market m);

        public abstract void PayByCard();
    }

    public class MarketBranch extends Market{

        List<Market> list = new ArrayList<Market>();

        public MarketBranch(String s) {
            this.name = s;
        }

        public void add(Market m) {
            list.add(m);
        }

        public void remove(Market m) {
            list.remove(m);
        }

        public void PayByCard() {
            System .out.println(name + "消费积分已经已累计加入会员卡");
            for (Market m : list){
                m.PayByCard();
            }
        }
    }

    public class MarketJoin extends Market{

        public MarketJoin(String s){
            this.name = s;
        }

        public void add(Market m) {

        }

        public void remove(Market m) {

        }

        public void PayByCard() {
            System .out.println(name + "消费积分已经已累计加入会员卡");
        }
    }

    public static void main(String[] args){
        PayDemo payDemo = new PayDemo();

        MarketBranch rootBreanch = payDemo.new MarketBranch("总店");
        MarketBranch qhdBreanch = payDemo.new MarketBranch("秦皇岛分店");
        MarketJoin hgqJoin = payDemo.new MarketJoin("秦皇岛分店一海港区加盟店");
        MarketJoin btlJoin = payDemo.new MarketJoin("秦皇岛分店二白塔岭加盟店");

        qhdBreanch.add(hgqJoin);
        qhdBreanch.add(btlJoin);
        rootBreanch.add(qhdBreanch);
        rootBreanch.PayByCard();
    }

}
