package com.demo.web.demo.bo;


import com.google.errorprone.annotations.Var;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CodeDo implements Serializable {

    public static HashMap<String, Map<String, String>> codeMap = new HashMap<String, Map<String, String>>();

    /**
     * 返回map的样子
     * "msg" -> "未知错误"
     * "code" -> "99922"
     * "system" -> "pokweb"
     *
     * @param code
     * @return
     */
    public static Map getcode(String code) {
        Map<String, String> cod = codeMap.get(code);
        return cod;
    }

    public void setCode(List<Map<String, String>> maps) {
        if (maps == null && maps.size() == 0) {
            return;
        }
        for (Map<String, String> map : maps) {
            String code = map.get("code");
            codeMap.put(code, map);
        }
    }


}
