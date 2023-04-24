package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TdCourseMapper;
import com.ruoyi.system.domain.TdCourse;
import com.ruoyi.system.service.ITdCourseService;

/**
 * 课程Service业务层处理
 * 
 * @author zhangyan
 * @date 2023-04-24
 */
@Service
public class TdCourseServiceImpl implements ITdCourseService 
{
    @Autowired
    private TdCourseMapper tdCourseMapper;

    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    @Override
    public TdCourse selectTdCourseById(Long id)
    {
        return tdCourseMapper.selectTdCourseById(id);
    }

    /**
     * 查询课程列表
     * 
     * @param tdCourse 课程
     * @return 课程
     */
    @Override
    public List<TdCourse> selectTdCourseList(TdCourse tdCourse)
    {
        return tdCourseMapper.selectTdCourseList(tdCourse);
    }

    /**
     * 新增课程
     * 
     * @param tdCourse 课程
     * @return 结果
     */
    @Override
    public int insertTdCourse(TdCourse tdCourse)
    {
        return tdCourseMapper.insertTdCourse(tdCourse);
    }

    /**
     * 修改课程
     * 
     * @param tdCourse 课程
     * @return 结果
     */
    @Override
    public int updateTdCourse(TdCourse tdCourse)
    {
        return tdCourseMapper.updateTdCourse(tdCourse);
    }

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的课程主键
     * @return 结果
     */
    @Override
    public int deleteTdCourseByIds(Long[] ids)
    {
        return tdCourseMapper.deleteTdCourseByIds(ids);
    }

    /**
     * 删除课程信息
     * 
     * @param id 课程主键
     * @return 结果
     */
    @Override
    public int deleteTdCourseById(Long id)
    {
        return tdCourseMapper.deleteTdCourseById(id);
    }
}
