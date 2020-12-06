package com.atguigu.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: OssService
 * @description: TODO
 * @author: spx
 * @create: 2020-12-03 21:27
 * @Version 1.0
 **/
public interface OssService {
    //上传头像到oss
    String uploadFileAvatar(MultipartFile file);

}
