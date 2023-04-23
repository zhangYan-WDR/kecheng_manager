package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.model.RegisterBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TdTeacherMapper;
import com.ruoyi.system.domain.TdTeacher;
import com.ruoyi.system.service.ITdTeacherService;

/**
 * 教师管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-23
 */
@Service
public class TdTeacherServiceImpl implements ITdTeacherService 
{
    @Autowired
    private TdTeacherMapper tdTeacherMapper;

    /**
     * 查询教师管理
     * 
     * @param id 教师管理主键
     * @return 教师管理
     */
    @Override
    public TdTeacher selectTdTeacherById(Long id)
    {
        return tdTeacherMapper.selectTdTeacherById(id);
    }

    /**
     * 查询教师管理列表
     * 
     * @param tdTeacher 教师管理
     * @return 教师管理
     */
    @Override
    public List<TdTeacher> selectTdTeacherList(TdTeacher tdTeacher)
    {
        return tdTeacherMapper.selectTdTeacherList(tdTeacher);
    }

    /**
     * 新增教师管理
     * 
     * @param tdTeacher 教师管理
     * @return 结果
     */
    @Override
    public int insertTdTeacher(TdTeacher tdTeacher)
    {
        return tdTeacherMapper.insertTdTeacher(tdTeacher);
    }

    /**
     * 修改教师管理
     * 
     * @param tdTeacher 教师管理
     * @return 结果
     */
    @Override
    public int updateTdTeacher(TdTeacher tdTeacher)
    {
        return tdTeacherMapper.updateTdTeacher(tdTeacher);
    }

    /**
     * 批量删除教师管理
     * 
     * @param ids 需要删除的教师管理主键
     * @return 结果
     */
    @Override
    public int deleteTdTeacherByIds(Long[] ids)
    {
        return tdTeacherMapper.deleteTdTeacherByIds(ids);
    }

    /**
     * 删除教师管理信息
     * 
     * @param id 教师管理主键
     * @return 结果
     */
    @Override
    public int deleteTdTeacherById(Long id)
    {
        return tdTeacherMapper.deleteTdTeacherById(id);
    }

    @Override
    public void saveByType(RegisterBody registerBody) {

    }
}
