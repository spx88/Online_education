package com.atguigu.mail.service.Impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.mail.service.ActiveMQService;
import com.atguigu.mail.entity.MailFormat;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ActiveMQServiceImpl
 * @description: TODO
 * @author: spx
 * @create: 2020-12-07 10:22
 * @Version 1.0
 **/
@Service
@Data
public class ActiveMQServiceImpl implements ActiveMQService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    JmsTemplate template;

    @Value("${com.sam.mail.queue}")
    private String queueName;

    @Override
    public void sendMQ(String[] to, String subject, String context) {

        this.sendMQ(to, subject, context, null);
    }

    @Override
    public void sendMQ(String[] to, String subject, String context, String filePath) {
        this.sendMQ(to, subject, context, filePath, null);
    }

    @Override
    public void sendMQ(String[] to, String subject, String context, String filePath, String srcId) {
        MailFormat mailFormat = new MailFormat();
        mailFormat.setTo(to);
        mailFormat.setSubject(subject);
        mailFormat.setContext(context);
        mailFormat.setFilePath(filePath);
        mailFormat.setSrcId(srcId);
        //BeanUtils.copyProperties();
        template.convertAndSend(queueName, mailFormat);
        logger.info("邮件已经发送到MQ:" + JSON.toJSONString(mailFormat));
    }
}
