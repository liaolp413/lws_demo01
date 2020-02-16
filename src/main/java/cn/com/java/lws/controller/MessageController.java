package cn.com.java.lws.controller;

import cn.com.java.lws.utils.QiNiuUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 *   消息的控制器层
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    //上传图片
    @RequestMapping("/uploadImage")
    public @ResponseBody Map<String,Object> uploadImage(MultipartFile file){
        return QiNiuUtils.upload(file);
    }

    //上传文件
    @RequestMapping("/uploadFile")
    public @ResponseBody Map<String,Object> uploadFile(MultipartFile file){
        return QiNiuUtils.upload(file);
    }
}
