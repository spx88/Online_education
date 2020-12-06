package com.atguigu.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ConstantPropertiesUtils
 * @description: TODO
 * @author: spx
 * @create: 2020-12-03 21:14
 * @Version 1.0
 **/
@Component
public class ConstantPropertiesUtils  implements InitializingBean {
    //读取配置文件内容
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String keyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String keySecret;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    //定义公开静态常量
    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;


    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID = keyId;
        ACCESS_KEY_SECRET = keySecret;
        BUCKET_NAME = bucketName;
    }
}
