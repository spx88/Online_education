package com.atguigu.mail.listener;

import com.atguigu.mail.entity.MailFormat;
import com.atguigu.mail.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.ObjectMessage;
import java.io.Serializable;

/**
 * @ClassName: SendMailMQListener
 * @description: TODO
 * @author: spx
 * @create: 2020-12-07 10:32
 * @Version 1.0
 **/
@Service
public class SendMailMQListener {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MailService mailService;

    /**
     * 通过监听目标队列实现功能
     */
    @JmsListener(destination = "${com.sam.mail.queue}")
    public void dealSenderMailMQ(ObjectMessage message) {
        try {
            Serializable object = message.getObject();
            MailFormat mailFormat = (MailFormat) object;
            mailService.sendMail(mailFormat.getTo(), mailFormat.getSubject(), mailFormat.getContext(), mailFormat.getFilePath(), mailFormat.getSrcId());
            logger.error("消费者消费邮件信息成功");
        } catch (Exception ex) {
            logger.error("消费者消费邮件信息失败：" + ex);
        }

    }
}
