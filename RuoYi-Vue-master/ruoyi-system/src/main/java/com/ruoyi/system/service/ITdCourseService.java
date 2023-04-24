package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TdCourse;

/**
 * 课程Service接口
 * 
 * @author zhangyan
 * @date 2023-04-24
 */
public interface ITdCourseService 
{
    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    public TdCourse selectTdCourseById(Long id);

    /**
     * 查询课程列表
     * 
     * @param tdCourse 课程
     * @return 课程集合
     */
    public List<TdCourse> selectTdCourseList(TdCourse tdCourse);

    /**
     * 新增课程
     * 
     * @param tdCourse 课程
     * @return 结果
     */
    public int insertTdCourse(TdCourse tdCourse);

    /**
     * 修改课程
     * 
     * @param tdCourse 课程
     * @return 结果
     */
    public int updateTdCourse(TdCourse tdCourse);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的课程主键集合
     * @return 结果
     */
    public int deleteTdCourseByIds(Long[] ids);

    /**
     * 删除课程信息
     * 
     * @param id 课程主键
     * @return 结果
     */
    public int deleteTdCourseById(Long id);
}
