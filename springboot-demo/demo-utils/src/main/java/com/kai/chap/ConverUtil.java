package com.kai.chap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 类型转换器
 * @author hongok
 * @since 2018-12-26 14:12:37
 */
public final class ConverUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConverUtil.class);

    /**
     * 将对象 srcObj 转换为 destClass
     * 将一个对象的参数值转换到另一个对象中
     * @param destClass
     * @param srcObj
     * @param <T>
     * @return
     */
    public static <T> T convert(Class<T> destClass, Object srcObj){
        if(srcObj == null){
            LOGGER.error(srcObj + " is null!");
            throw new RuntimeException();
        }
        T obj = null;
        try {
            obj = newInstance(destClass);
            BeanUtils.copyProperties(obj, srcObj);
        } catch (Exception e) {
            LOGGER.error("properties copy failure!", e);
            throw new RuntimeException(e);
        }
        return obj;
    }

    /**
     * 将srcList 转换为 destClass
     * 将集合转换成另一个集合
     * @param destClass
     * @param srcList
     * @param <T>
     * @param <E>
     * @return
     */
    public static <T,E> List<T> convert(Class<T> destClass, List<E> srcList) {
        if (srcList == null) {
            LOGGER.error(srcList + " is null!");
            throw new RuntimeException();
        }
        List<T> destList = new ArrayList<T>();
        for (E srcObj : srcList){
            T obj = convert(destClass, srcObj);
            destList.add(obj);
        }
        return destList;
    }

    private static <T> T newInstance(Class<T> cls){
        T obj = null;
        try {
            obj = cls.newInstance();
        } catch (Exception e) {
            LOGGER.error("new instance " + cls.getName() + " failure!", e);
            throw new RuntimeException(e);
        }
        return obj;
    }

}
