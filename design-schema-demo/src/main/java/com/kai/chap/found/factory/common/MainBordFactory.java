package com.kai.chap.found.factory.common;

import com.kai.chap.found.factory.AmdMainBord;
import com.kai.chap.found.factory.IntelMainBord;
import com.kai.chap.found.factory.MainBord;

/**
 * 主板工厂类
 * @author hok
 * @since 2019-1-14 16:26:04
 */
public class MainBordFactory {

    public static MainBord createMainBord(int type){
        MainBord mainBord = null;
        if(type == 1){
            mainBord = new IntelMainBord(755);
        }else if (type == 2){
            mainBord = new AmdMainBord(938);
        }
        return mainBord;
    }

}
