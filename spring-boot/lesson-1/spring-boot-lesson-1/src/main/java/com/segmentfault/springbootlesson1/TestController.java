package com.segmentfault.springbootlesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/a")
public class TestController {

    @Autowired
    private Wx wx;


    @GetMapping(value = "/test")
    public String test(){
        return "aaaa";
    }

}
