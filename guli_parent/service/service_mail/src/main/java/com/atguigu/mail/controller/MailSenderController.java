package com.atguigu.mail.controller;

import com.atguigu.commonutils.R;
import com.atguigu.mail.entity.MailFormat;
import com.atguigu.mail.entity.vo.AttachMailVo;
import com.atguigu.mail.entity.vo.SimpleMailVo;
import com.atguigu.mail.service.ActiveMQService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: MailSenderController
 * @description: TODO
 * @author: spx
 * @create: 2020-12-07 10:28
 * @Version 1.0
 **/
@RestController
@RequestMapping("/edumail/mailsend")
@CrossOrigin
@Api(description = "邮件发送管理")
public class MailSenderController {
    @Resource
    ActiveMQService activeMQService;

    @PostMapping("/sendSimpleMail")
    @ApiOperation(value = "普通邮件发送")
    public R sendSimpleMail(@RequestBody SimpleMailVo simpleMailVo
    ) {
        activeMQService.sendMQ(simpleMailVo.getTo(), simpleMailVo.getSubject(),
                simpleMailVo.getContext());
        return R.ok();
    }


    @PostMapping("/sendAttachMail")
    @ApiOperation(value = "附件邮件发送")
    public R sendAttachMail(@RequestBody AttachMailVo attachMailVo) {
        //        String[] to = {mailTo};
        //        String subject = "带附件的邮件";
        //        String context = "<html><body>你好，<br>这是一封带附件的邮件，<br>具体请见附件</body></html>";
//        String filePath = "E:\\阿里云\\python.jpg";
        activeMQService.sendMQ(attachMailVo.getTo(), attachMailVo.getSubject(), attachMailVo.getContext(), attachMailVo.getFilePath());
        return R.ok();
    }

    @PostMapping("/sendMimeMail")
    @ApiOperation(value = "普通邮件有图片发送")
    public R sendMimeMail(@RequestBody MailFormat mailFormat) {
        //        String[] to = {mailTo};
        //        String subject = "普通邮件";
        //        String filePath = "E:\\阿里云\\python.jpg";
        //        String resId = "python.jpg";
        //        String context = "<html><body>你好，<br>这是一封带图片的邮件，<br>请见图片<br><img src=\'cid:" + resId + "\'></body></html>";
        activeMQService.sendMQ(mailFormat.getTo(), mailFormat.getSubject(), mailFormat.getContext(), mailFormat.getFilePath(), mailFormat.getSrcId());
        return R.ok();
    }
}
