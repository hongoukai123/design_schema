package com.kai.chap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

    /**
     * 对象转json字符串
     * @param obj
     * @return
     */
    public static String objChangeJsonStr(Object obj){
        JSONObject jsonObj = (JSONObject) JSON.toJSON(obj);
        return jsonObj.toString();
    }

    /**
     * 对象转json
     * @param obj
     * @return
     */
    public static JSONObject objChangeJson(Object obj){
        JSONObject jsonObj = (JSONObject) JSON.toJSON(obj);
        return jsonObj;
    }

}
