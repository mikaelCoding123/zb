package com.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ToolUtil {

    /**
     * @param orgMap
     * @param flag   flag =true map的key值转成大写，反之为小写
     * @return
     */
    public static Map<String, Object> keyToLowerCase(Map<String, Object> orgMap, boolean flag) {
        Map<String, Object> resultMap = new HashMap<>();
        if (orgMap == null || orgMap.isEmpty()) {
            return resultMap;
        }
        Set<Map.Entry<String, Object>> entrySet = orgMap.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (flag) {
                //大写
                resultMap.put(key.toUpperCase(), value);
            } else {
                //小写
                resultMap.put(key.toLowerCase(), value);
            }
        }
        return resultMap;
    }
}
