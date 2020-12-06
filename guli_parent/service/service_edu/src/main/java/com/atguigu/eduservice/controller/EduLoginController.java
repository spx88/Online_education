package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: EduLoginController
 * @description: TODO
 * @author: spx
 * @create: 2020-12-02 17:33
 * @Version 1.0
 **/
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin//解决跨域问题
@Api(description="登录")
public class EduLoginController {

    //login
    @PostMapping("login")
    public R login() {


        return R.ok().data("taken", "admin");
    }

    //info
    @GetMapping("info")
    public R info() {
        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606912055429&di=b6a2c9deb9148c06e8adcdb352691664&imgtype=0&src=http%3A%2F%2Fp.qqan.com%2Fup%2F2020-11%2F202011161118512882.jpg");
    }

}
