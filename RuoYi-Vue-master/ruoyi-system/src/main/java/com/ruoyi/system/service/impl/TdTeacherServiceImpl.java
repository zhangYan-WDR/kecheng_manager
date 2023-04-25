package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.RegisterBody;
import com.ruoyi.system.domain.SysUserRole;
import com.ruoyi.system.domain.TdStudent;
import com.ruoyi.system.mapper.SysRoleMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.SysUserRoleMapper;
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
public class TdTeacherServiceImpl extends ServiceImpl<TdTeacherMapper,TdTeacher> implements ITdTeacherService
{
    @Autowired
    private TdTeacherMapper tdTeacherMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

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
        TdTeacher tdTeacher = new TdTeacher();
        tdTeacher.setTeacherEmail(registerBody.getEmail());
        tdTeacher.setTeacherName(registerBody.getName());
        tdTeacher.setTeacherPassword(registerBody.getPassword());
        tdTeacher.setTeacherPhone(registerBody.getPhone());
        tdTeacher.setTeacherNo(registerBody.getNo());
        tdTeacher.setTeacherSex(registerBody.getSex());
        tdTeacherMapper.insertTdTeacher(tdTeacher);
        //查询系统用户的id
        SysUser sysUser = sysUserMapper.selectUserByUserName(tdTeacher.getTeacherName());
        //关联当前权限
        SysRole sysRole = sysRoleMapper.selectRoleByName("教师");
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUser.getUserId());
        sysUserRole.setRoleId(sysRole.getRoleId());
        ArrayList<SysUserRole> sysUserRoles = new ArrayList<>();
        sysUserRoles.add(sysUserRole);
        sysUserRoleMapper.batchUserRole(sysUserRoles);
    }
}
