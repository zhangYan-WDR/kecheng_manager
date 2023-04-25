package com.ruoyi.system.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.core.domain.model.RegisterBody;
import com.ruoyi.system.domain.TdTeacher;

/**
 * 教师管理Service接口
 * 
 * @author ruoyi
 * @date 2023-04-23
 */
public interface ITdTeacherService extends IService<TdTeacher>
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
     * 批量删除教师管理
     * 
     * @param ids 需要删除的教师管理主键集合
     * @return 结果
     */
    public int deleteTdTeacherByIds(Long[] ids);

    /**
     * 删除教师管理信息
     * 
     * @param id 教师管理主键
     * @return 结果
     */
    public int deleteTdTeacherById(Long id);

    void saveByType(RegisterBody registerBody);
}
