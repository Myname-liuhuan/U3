package com.example.controller.upload;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: 刘欢
 * @Date: 2019/11/3 11:13
 */
@Controller
@RequestMapping("uploadServlet")
public class UploadController {

    /**
     * 处理单文件上传
     * 参数类型规定为 MultipartFile
     * 参数名要与前端页面标签的 name属性名一样
     * 大致操作就是:
     * 解析文件 提取后缀 更改文件名
     * 创建路径 判断路径 生成路径 拼接成完整路径
     * 写入数据
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file){
        //得到文件的原始名字
        String originalFilename = file.getOriginalFilename();
        //提取后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //生成新的文件名的身体'.'前面的部分
        String fileNameBody = UUID.randomUUID().toString();
        //完整文件名
        String fileName = fileNameBody+suffix;

        //生成文件上传路径,使用日期转化,将当前事件精确到秒 转化为多级目录
        String fileDir = new SimpleDateFormat("yyyy\\MM\\dd\\HH\\mm\\ss").format(new Date());
        //判断路径是否存在 需要使用File类
        File isDir  = new File("E:\\ssm\\load",fileDir);
        if (!isDir.exists()){
            isDir.mkdirs();
        }
        File lastFile = new File(isDir,fileName);

        try {
            //该方法为spring-mvc自带的
            file.transferTo(lastFile);
            return "fail";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
