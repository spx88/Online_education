package com.atguigu.mail.entity.vo;

import lombok.Data;

/**
 * @ClassName: SimpleMailVo
 * @description: TODO
 * @author: spx
 * @create: 2020-12-07 17:50
 * @Version 1.0
 **/
@Data
public class SimpleMailVo {

    private String[] to;//收件人列表
    private String subject;//邮件主题
    private String context;//邮件正文
}
