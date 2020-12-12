package com.atguigu.mail.service;

/**
 * @ClassName: MailService
 * @description: TODO
 * @author: spx
 * @create: 2020-12-07 16:35
 * @Version 1.0
 **/
public interface MailService {
    void sendSimpleMail(String to, String subject, String context);

    void sendAttachMail(String[] to, String subject, String context, String filePath);

    void sendInlineMail(String to, String subject, String context, String filePath, String resId);

    void sendMail(String[] to, String subject, String context, String filePath, String resId);
}
