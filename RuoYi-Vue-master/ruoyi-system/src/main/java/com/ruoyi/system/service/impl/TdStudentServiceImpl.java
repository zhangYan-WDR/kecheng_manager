package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.RegisterBody;
import com.ruoyi.system.domain.SysUserRole;
import com.ruoyi.system.mapper.SysRoleMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TdStudentMapper;
import com.ruoyi.system.domain.TdStudent;
import com.ruoyi.system.service.ITdStudentService;

/**
 * 学生Service业务层处理
 * 
 * @author zhangyan
 * @date 2023-04-23
 */
@Service
public class TdStudentServiceImpl extends ServiceImpl<TdStudentMapper,TdStudent> implements ITdStudentService
{
    @Autowired
    private TdStudentMapper tdStudentMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询学生
     * 
     * @param id 学生主键
     * @return 学生
     */
    @Override
    public TdStudent selectTdStudentById(Long id)
    {
        return tdStudentMapper.selectTdStudentById(id);
    }

    /**
     * 查询学生列表
     * 
     * @param tdStudent 学生
     * @return 学生
     */
    @Override
    public List<TdStudent> selectTdStudentList(TdStudent tdStudent)
    {
        return tdStudentMapper.selectTdStudentList(tdStudent);
    }

    /**
     * 新增学生
     * 
     * @param tdStudent 学生
     * @return 结果
     */
    @Override
    public int insertTdStudent(TdStudent tdStudent)
    {
        return tdStudentMapper.insertTdStudent(tdStudent);
    }

    /**
     * 修改学生
     * 
     * @param tdStudent 学生
     * @return 结果
     */
    @Override
    public int updateTdStudent(TdStudent tdStudent)
    {
        return tdStudentMapper.updateTdStudent(tdStudent);
    }

    /**
     * 批量删除学生
     * 
     * @param ids 需要删除的学生主键
     * @return 结果
     */
    @Override
    public int deleteTdStudentByIds(Long[] ids)
    {
        return tdStudentMapper.deleteTdStudentByIds(ids);
    }

    /**
     * 删除学生信息
     * 
     * @param id 学生主键
     * @return 结果
     */
    @Override
    public int deleteTdStudentById(Long id)
    {
        return tdStudentMapper.deleteTdStudentById(id);
    }

    @Override
    public void saveByType(RegisterBody registerBody) {
        TdStudent tdStudent = new TdStudent();
        tdStudent.setStudentEmail(registerBody.getEmail());
        tdStudent.setStudentGrade(registerBody.getGrade());
        tdStudent.setStudentName(registerBody.getName());
        tdStudent.setStudentPassword(registerBody.getPassword());
        tdStudent.setStudentPhone(registerBody.getPhone());
        tdStudent.setStudentNo(registerBody.getNo());
        baseMapper.insertTdStudent(tdStudent);
        //查询系统用户的id
        SysUser sysUser = sysUserMapper.selectUserByUserName(tdStudent.getStudentName());
        //关联当前权限
        SysRole sysRole = sysRoleMapper.selectRoleByName("学生");
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUser.getUserId());
        sysUserRole.setRoleId(sysRole.getRoleId());
        ArrayList<SysUserRole> sysUserRoles = new ArrayList<>();
        sysUserRoles.add(sysUserRole);
        sysUserRoleMapper.batchUserRole(sysUserRoles);
    }
}
