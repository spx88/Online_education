package com.atguigu.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.atguigu.oss.service.OssService;
import com.atguigu.oss.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName: OssServiceImpl
 * @description: TODO
 * @author: spx
 * @create: 2020-12-03 21:28
 * @Version 1.0
 **/
@Service
public class OssServiceImpl implements OssService {


    //上传文件到oss
    @Override
    public String uploadFileAvatar(MultipartFile file) {
        //通过工具类来获取值 地域节点 id 密钥 bucketName
        String endpoint = ConstantPropertiesUtils.END_POINT;
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;


        try {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 获取上传文件输入流。
            InputStream inputStream = file.getInputStream();

            //获取文件名称
            String fileName = file.getOriginalFilename();


            //1 在文件名称里面添加随机唯一的值
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            fileName = uuid + fileName;

            //2 把文件按照日期进行分类
            //获取当前日期
            String datePath = new DateTime().toString("yyyy/MM/dd");

            //拼接


            fileName = datePath + "/" + fileName;

            //调用oss方法实现上传
            //第一个参数 bucket名称
            //第二个参数 上传到oss文件路径和文件名称
            //第三个参数  上传文件输入流
            ossClient.putObject(bucketName, fileName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();

            //把上传之后文件路径返回
            //需要上传到阿里云oss路径手动拼接出来
            //https://edu-9816.oss-cn-beijing.aliyuncs.com/5b3fcea89f32b9b3bc8a52dfd1a30fd4.jpg
            String url = "https://" + bucketName + "." + endpoint + "/" + fileName;
            return url;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
