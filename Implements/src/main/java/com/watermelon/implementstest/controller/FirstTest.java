package com.watermelon.implementstest.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author yanyan
 * @date 2019/04/03
 */
@Controller
public class FirstTest {

    @RequestMapping("test")
    @ResponseBody
    public Map<String,String> test(){
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("msg","dragoninfo");
        return hashMap;
    }

    @ResponseBody
    @PostMapping(value = "test2", produces = "application/json;charset=UTF-8")
    public String getByJSON(@RequestBody JSONObject jsonParam) {
        // 直接将json信息打印出来
        System.out.println(jsonParam.toJSONString());
        // 将获取的json数据封装一层，然后在给返回
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "json");
        result.put("data", jsonParam);
        return result.toJSONString();
    }

}
