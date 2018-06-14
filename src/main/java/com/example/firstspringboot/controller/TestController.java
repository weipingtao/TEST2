package com.example.firstspringboot.controller;

import com.example.firstspringboot.entity.User;
import com.example.firstspringboot.repository.UserRepository;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/wpt")
    public String wpt(){
        return "Hello wpt!";
    }


    @PostMapping("/test")
    @ApiOperation(value = "test",notes = "{\"name\":\"string\",\"age\":\"string\"}")
    @ResponseBody
    public Map test( @RequestBody Map<String,String> map){
        String name=map.get("name");
        String age=map.get("age");
        Map<String,Object> map1=new HashMap();
        map1.put("姓名",name);
        map1.put("年龄",age);
        return map1;
    }

    @PostMapping("/jpa")
    @ResponseBody
    public Map jpaTest(@RequestBody Map<String,String> map){
        User user = new User();
        user.setName(map.get("name"));
        user.setPassword(map.get("password"));
        user.setBirthday(map.get("birthday"));
        userRepository.save(user);
        Map<String,Object> map1=new HashMap();
        map1.put("msg","jpa成功了");
        return map1;
    }
}
