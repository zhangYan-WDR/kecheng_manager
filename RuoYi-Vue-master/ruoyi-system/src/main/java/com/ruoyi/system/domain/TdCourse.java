package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程对象 td_course
 * 
 * @author zhangyan
 * @date 2023-04-24
 */
public class TdCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程表主键 */
    private Long id;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private String courseNo;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 课程性质 */
    @Excel(name = "课程性质")
    private String courseQuality;

    /** 考察形式 */
    @Excel(name = "考察形式")
    private String inspectModality;

    /** 实践学时 */
    @Excel(name = "实践学时")
    private String practicalHours;

    /** 开设学期 */
    @Excel(name = "开设学期")
    private String openTerm;

    /** 学分 */
    @Excel(name = "学分")
    private Long credit;

    /** 理论学时 */
    @Excel(name = "理论学时")
    private String theoreticalHours;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCourseNo(String courseNo) 
    {
        this.courseNo = courseNo;
    }

    public String getCourseNo() 
    {
        return courseNo;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setCourseQuality(String courseQuality) 
    {
        this.courseQuality = courseQuality;
    }

    public String getCourseQuality() 
    {
        return courseQuality;
    }
    public void setInspectModality(String inspectModality) 
    {
        this.inspectModality = inspectModality;
    }

    public String getInspectModality() 
    {
        return inspectModality;
    }
    public void setPracticalHours(String practicalHours) 
    {
        this.practicalHours = practicalHours;
    }

    public String getPracticalHours() 
    {
        return practicalHours;
    }
    public void setOpenTerm(String openTerm) 
    {
        this.openTerm = openTerm;
    }

    public String getOpenTerm() 
    {
        return openTerm;
    }
    public void setCredit(Long credit) 
    {
        this.credit = credit;
    }

    public Long getCredit() 
    {
        return credit;
    }
    public void setTheoreticalHours(String theoreticalHours) 
    {
        this.theoreticalHours = theoreticalHours;
    }

    public String getTheoreticalHours() 
    {
        return theoreticalHours;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("courseNo", getCourseNo())
            .append("courseName", getCourseName())
            .append("courseQuality", getCourseQuality())
            .append("inspectModality", getInspectModality())
            .append("practicalHours", getPracticalHours())
            .append("openTerm", getOpenTerm())
            .append("credit", getCredit())
            .append("theoreticalHours", getTheoreticalHours())
            .toString();
    }
}
