package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TdCoursewareBank;

/**
 * 课程库Mapper接口
 * 
 * @author zhangyan
 * @date 2023-04-24
 */
public interface TdCoursewareBankMapper 
{
    /**
     * 查询课程库
     * 
     * @param id 课程库主键
     * @return 课程库
     */
    public TdCoursewareBank selectTdCoursewareBankById(Long id);

    /**
     * 查询课程库列表
     * 
     * @param tdCoursewareBank 课程库
     * @return 课程库集合
     */
    public List<TdCoursewareBank> selectTdCoursewareBankList(TdCoursewareBank tdCoursewareBank);

    /**
     * 新增课程库
     * 
     * @param tdCoursewareBank 课程库
     * @return 结果
     */
    public int insertTdCoursewareBank(TdCoursewareBank tdCoursewareBank);

    /**
     * 修改课程库
     * 
     * @param tdCoursewareBank 课程库
     * @return 结果
     */
    public int updateTdCoursewareBank(TdCoursewareBank tdCoursewareBank);

    /**
     * 删除课程库
     * 
     * @param id 课程库主键
     * @return 结果
     */
    public int deleteTdCoursewareBankById(Long id);

    /**
     * 批量删除课程库
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTdCoursewareBankByIds(Long[] ids);
}
