package com.atguigu.mail.entity;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassName: MailFormat
 * @description: TODO
 * @author: spx
 * @create: 2020-12-07 10:26
 * @Version 1.0
 **/
@Data
public class MailFormat implements Serializable {

    private String from;//发件人
    private String[] to;//收件人列表
    private String subject;//邮件主题
    private String context;//邮件正文
    private String filePath;//文件（图片）路径
    private String srcId;//图片名
}
