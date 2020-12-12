package com.atguigu.mail.service;

/**
 * @ClassName: ActiveMQService
 * @description: TODO
 * @author: spx
 * @create: 2020-12-07 10:20
 * @Version 1.0
 **/
public interface ActiveMQService {

    //普通文本邮件
    void sendMQ(String[] to, String subject, String context);

    //附件文本邮件
    void sendMQ(String[] to, String subject, String context, String filePath);

    //带图片邮件
    void sendMQ(String[] to, String subject, String context, String filePath, String srcId);
    //void sendMQ();
}
