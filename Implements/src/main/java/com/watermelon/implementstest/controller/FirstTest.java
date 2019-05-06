package com.watermelon.implementstest.controller;


import com.alibaba.fastjson.JSONObject;
import com.watermelon.implementstest.dto.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API test class
 *
 * @author yanyan
 * @date 2019/04/03
 */
@Controller
public class FirstTest {

    /**
     * json
     */
    @RequestMapping("test")
    @ResponseBody
    public Map<String,String> test(){
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("msg","dragoninfo");
        return hashMap;
    }

    /**
     * json
     */
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
        result.put("yan","test");
        result.put("yanyan","cool");
        return result.toJSONString();
    }


    /**
     * x-www-form-urlencoded
     */
    @ResponseBody
    @PostMapping("/prm/parameterDownHandler")
    public String  downHanler(@RequestParam("username")String username,@RequestParam("password")String password ){
        JSONObject jsonObject = new JSONObject();
        System.out.println("name: "+username+"; "+"password: "+password);
        jsonObject.put("username","yan");
        jsonObject.put("password","123456");
        return jsonObject.toJSONString();
    }

    /**
    *  xml
    * */
    @PostMapping(value = "/user",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User create(@RequestBody User user) {
        user.setName("username" + user.getName());
        user.setAge(user.getAge() + 100);
        return user;
    }
    
    //just a 5555...
}
