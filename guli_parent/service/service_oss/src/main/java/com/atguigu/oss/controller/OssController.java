package com.atguigu.oss.controller;

import com.atguigu.commonutils.R;
import com.atguigu.oss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @ClassName: OssController
 * @description: TODO
 * @author: spx
 * @create: 2020-12-03 21:27
 * @Version 1.0
 **/

@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
@Api(description="阿里云oss管理")
public class OssController {


    @Autowired
    private OssService ossService;

    //上传头像的方法
    @PostMapping
    @ApiOperation(value = "oss文件上传")
    public R uploadOssFile(MultipartFile file) {

        //获取上传文件
        String url = ossService.uploadFileAvatar(file);

        return R.ok().data("url", url);
    }
}
