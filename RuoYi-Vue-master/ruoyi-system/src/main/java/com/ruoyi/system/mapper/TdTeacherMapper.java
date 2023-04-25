package com.ruoyi.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.TdTeacher;

/**
 * 教师管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-23
 */
public interface TdTeacherMapper extends BaseMapper<TdTeacher>
{
    /**
     * 查询教师管理
     * 
     * @param id 教师管理主键
     * @return 教师管理
     */
    public TdTeacher selectTdTeacherById(Long id);

    /**
     * 查询教师管理列表
     * 
     * @param tdTeacher 教师管理
     * @return 教师管理集合
     */
    public List<TdTeacher> selectTdTeacherList(TdTeacher tdTeacher);

    /**
     * 新增教师管理
     * 
     * @param tdTeacher 教师管理
     * @return 结果
     */
    public int insertTdTeacher(TdTeacher tdTeacher);

    /**
     * 修改教师管理
     * 
     * @param tdTeacher 教师管理
     * @return 结果
     */
    public int updateTdTeacher(TdTeacher tdTeacher);

    /**
     * 删除教师管理
     * 
     * @param id 教师管理主键
     * @return 结果
     */
    public int deleteTdTeacherById(Long id);

    /**
     * 批量删除教师管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTdTeacherByIds(Long[] ids);
}
