package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生对象 td_student
 * 
 * @author zhangyan
 * @date 2023-04-23
 */
@TableName("td_student")
public class TdStudent
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String studentNo;

    /** 姓名 */
    @Excel(name = "姓名")
    private String studentName;

    /** 电话 */
    @Excel(name = "电话")
    private String studentPhone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String studentEmail;

    /** 年级 */
    @Excel(name = "年级")
    private String studentGrade;

    /** 密码 */
    private String studentPassword;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStudentNo(String studentNo) 
    {
        this.studentNo = studentNo;
    }

    public String getStudentNo() 
    {
        return studentNo;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }
    public void setStudentPhone(String studentPhone) 
    {
        this.studentPhone = studentPhone;
    }

    public String getStudentPhone() 
    {
        return studentPhone;
    }
    public void setStudentEmail(String studentEmail) 
    {
        this.studentEmail = studentEmail;
    }

    public String getStudentEmail() 
    {
        return studentEmail;
    }
    public void setStudentGrade(String studentGrade) 
    {
        this.studentGrade = studentGrade;
    }

    public String getStudentGrade() 
    {
        return studentGrade;
    }
    public void setStudentPassword(String studentPassword) 
    {
        this.studentPassword = studentPassword;
    }

    public String getStudentPassword() 
    {
        return studentPassword;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentNo", getStudentNo())
            .append("studentName", getStudentName())
            .append("studentPhone", getStudentPhone())
            .append("studentEmail", getStudentEmail())
            .append("studentGrade", getStudentGrade())
            .append("studentPassword", getStudentPassword())
            .toString();
    }
}
