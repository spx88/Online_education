package com.atguigu.eduservice.linser;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.service.EduSubjectService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * @ClassName: SubjectExcelLinstener
 * @description: TODO
 * @author: spx
 * @create: 2020-12-04 21:42
 * @Version 1.0
 **/
public class SubjectExcelLinstener extends AnalysisEventListener<SubjectData> {


    //因为SubjectExcelLinstener不能交给spring进行管理，需要自己new，不能注入其他对象
    public EduSubjectService subjectService;

    public SubjectExcelLinstener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public SubjectExcelLinstener() {
    }

    //读取excel内容，一行一行读取
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext context) {
        if (subjectService == null) {
            throw new GuliException(20001, "文件数据为空");

        }
        //一行一行读取，每次读取俩个只，第一个一级分类，第二个二级分类
        //判断一级分类是否重复
        //添加一级分类
        EduSubject existOneSubject = this.existOneSubject(subjectService, subjectData.getOneSubjectName());
        if (existOneSubject == null) { //没有相同的一级分类，进行添加
            existOneSubject = new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(subjectData.getOneSubjectName()); //一级分类名称
            subjectService.save(existOneSubject);

        }

        //获取一级分类id值
        String pid = existOneSubject.getId();
        //添加二级分类
        //判断二级分类是否重复
        EduSubject existTwoSubject = this.existTwoSubject(subjectService, subjectData.getTwoSubjectName(), pid);
        if (existTwoSubject == null) {
            existOneSubject = new EduSubject();
            existOneSubject.setParentId(pid);   //二级分类的父亲id根据一级分类id取值
            existOneSubject.setTitle(subjectData.getTwoSubjectName()); //二级分类名称
            subjectService.save(existOneSubject);

        }
    }

    //判断一级分类不能重复添加
    private EduSubject existOneSubject(EduSubjectService subjectService, String name) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "0");
        EduSubject oneSubject = subjectService.getOne(wrapper);
        return oneSubject;
    }

    //判断二级分类不能重复添加
    private EduSubject existTwoSubject(EduSubjectService subjectService, String name, String pid) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "pid");
        EduSubject twoSubject = subjectService.getOne(wrapper);
        return twoSubject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
