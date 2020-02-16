package cn.com.java.lws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  页面跳转控制器
 */
@Controller
@RequestMapping("/model")
public class ModelController {

    @RequestMapping("/toLayout")
    public String toLayout(){
        return "layout";
    }
}
