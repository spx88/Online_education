package com.atguigu.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName: SubjectData
 * @description: TODO
 * @author: spx
 * @create: 2020-12-04 21:36
 * @Version 1.0
 **/

@Data
//与excel对应的实体类
public class SubjectData {


    @ExcelProperty(index = 0)
    private String oneSubjectName;

    @ExcelProperty(index = 1)
    private String twoSubjectName;
}
