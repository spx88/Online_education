package com.atguigu.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OneSubject
 * @description: TODO
 * @author: spx
 * @create: 2020-12-05 10:49
 * @Version 1.0
 **/

//一级分类
@Data
public class OneSubject {
    private String id;

    private String title;

    //一个一级分类有多个二级分类
    private List<TwoSubject> children = new ArrayList<>();


}
