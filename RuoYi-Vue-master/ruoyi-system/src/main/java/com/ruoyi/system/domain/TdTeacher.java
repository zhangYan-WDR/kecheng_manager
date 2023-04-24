package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师管理对象 td_teacher
 * 
 * @author ruoyi
 * @date 2023-04-23
 */
public class TdTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String teacherNo;

    /** 姓名 */
    @Excel(name = "姓名")
    private String teacherName;

    /** 电话 */
    @Excel(name = "电话")
    private String teacherPhone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String teacherEmail;

    /** 性别 */
    @Excel(name = "性别")
    private String teacherSex;

    /** 密码 */
    private String teacherPassword;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTeacherNo(String teacherNo) 
    {
        this.teacherNo = teacherNo;
    }

    public String getTeacherNo() 
    {
        return teacherNo;
    }
    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }
    public void setTeacherPhone(String teacherPhone) 
    {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherPhone() 
    {
        return teacherPhone;
    }
    public void setTeacherEmail(String teacherEmail) 
    {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherEmail() 
    {
        return teacherEmail;
    }
    public void setTeacherSex(String teacherSex) 
    {
        this.teacherSex = teacherSex;
    }

    public String getTeacherSex() 
    {
        return teacherSex;
    }
    public void setTeacherPassword(String teacherPassword) 
    {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherPassword() 
    {
        return teacherPassword;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teacherNo", getTeacherNo())
            .append("teacherName", getTeacherName())
            .append("teacherPhone", getTeacherPhone())
            .append("teacherEmail", getTeacherEmail())
            .append("teacherSex", getTeacherSex())
            .append("teacherPassword", getTeacherPassword())
            .toString();
    }
}
