package com.dmm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 杨德石
 * @Date: 2019/12/22 18:20
 * @Version 1.0
 */
@Controller
@RequestMapping("/")
public class RedirectController {

    @RequestMapping("/index.action")
    public String index() {
        return "index";
    }

    @RequestMapping("/")
    public String index2() {
        return "index";
    }

}
