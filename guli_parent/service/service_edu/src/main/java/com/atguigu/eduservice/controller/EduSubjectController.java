package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.subject.OneSubject;
import com.atguigu.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/eduservice/subject")
//解决跨域问题
@CrossOrigin
@Api(description = "课程分类管理")
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    //添加课程分类
    //获取上传文件，把文件内容读取出来
    @ApiOperation(value = "上传课程分类的excel文件读取至数据库")
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file) {


        subjectService.saveSubject(file, subjectService);
        //上传过来excel文件
        return R.ok();
    }

    //课程分类的列表功能(树形结构)
    @ApiOperation(value = "课程分类列表树形展示")
    @GetMapping("getAllSubject")
    public R getAllSubject() {
        //list集合泛型是一级分类
        List<OneSubject> list = subjectService.getAllOneTwoSubject();
        return R.ok().data("list", list);
    }

    //逻辑删除课程分类
    @ApiOperation(value = "课程分类的删除")
    @DeleteMapping("{id}")
    public R removeSubject(@ApiParam(name = "id", value = "课程分类ID", required = true)
                           @PathVariable String id) {
        boolean flag = subjectService.removeById(id);

        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

}

