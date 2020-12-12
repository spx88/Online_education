package com.atguigu.mail.entity.vo;

import lombok.Data;

/**
 * @ClassName: AttcahMailVo
 * @description: TODO
 * @author: spx
 * @create: 2020-12-07 19:09
 * @Version 1.0
 **/
@Data
public class AttachMailVo {
    private String[] to;//收件人列表
    private String subject;//邮件主题
    private String context;//邮件正文
    private String filePath;//文件（图片）路径
}
