package com.ruoyi.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.TdStudent;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生Mapper接口
 * 
 * @author zhangyan
 * @date 2023-04-23
 */
@Mapper
public interface TdStudentMapper extends BaseMapper<TdStudent>
{
    /**
     * 查询学生
     * 
     * @param id 学生主键
     * @return 学生
     */
    public TdStudent selectTdStudentById(Long id);

    /**
     * 查询学生列表
     * 
     * @param tdStudent 学生
     * @return 学生集合
     */
    public List<TdStudent> selectTdStudentList(TdStudent tdStudent);

    /**
     * 新增学生
     * 
     * @param tdStudent 学生
     * @return 结果
     */
    public int insertTdStudent(TdStudent tdStudent);

    /**
     * 修改学生
     * 
     * @param tdStudent 学生
     * @return 结果
     */
    public int updateTdStudent(TdStudent tdStudent);

    /**
     * 删除学生
     * 
     * @param id 学生主键
     * @return 结果
     */
    public int deleteTdStudentById(Long id);

    /**
     * 批量删除学生
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTdStudentByIds(Long[] ids);
}
