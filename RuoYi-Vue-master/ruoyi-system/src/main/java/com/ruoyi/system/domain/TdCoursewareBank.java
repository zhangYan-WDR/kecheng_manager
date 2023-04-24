package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程库对象 td_courseware_bank
 * 
 * @author zhangyan
 * @date 2023-04-24
 */
public class TdCoursewareBank extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课件库id */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 章节 */
    @Excel(name = "章节")
    private String section;

    /** 课件编号 */
    @Excel(name = "课件编号")
    private String coursewareNo;

    /** 浏览次数 */
    @Excel(name = "浏览次数")
    private Long viewCount;

    /** 下载次数 */
    @Excel(name = "下载次数")
    private Long downloadCount;

    /** 上传作者 */
    @Excel(name = "上传作者")
    private String uploadAuthor;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long fileSize;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private String courseNo;

    /** 文件 */
    @Excel(name = "文件")
    private String file;

    /** 是否审核 */
    @Excel(name = "是否审核")
    private String isChecked;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uploadTime;

    /** 资源类型 */
    @Excel(name = "资源类型")
    private String type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setSection(String section) 
    {
        this.section = section;
    }

    public String getSection() 
    {
        return section;
    }
    public void setCoursewareNo(String coursewareNo) 
    {
        this.coursewareNo = coursewareNo;
    }

    public String getCoursewareNo() 
    {
        return coursewareNo;
    }
    public void setViewCount(Long viewCount) 
    {
        this.viewCount = viewCount;
    }

    public Long getViewCount() 
    {
        return viewCount;
    }
    public void setDownloadCount(Long downloadCount) 
    {
        this.downloadCount = downloadCount;
    }

    public Long getDownloadCount() 
    {
        return downloadCount;
    }
    public void setUploadAuthor(String uploadAuthor) 
    {
        this.uploadAuthor = uploadAuthor;
    }

    public String getUploadAuthor() 
    {
        return uploadAuthor;
    }
    public void setFileSize(Long fileSize) 
    {
        this.fileSize = fileSize;
    }

    public Long getFileSize() 
    {
        return fileSize;
    }
    public void setCourseNo(String courseNo) 
    {
        this.courseNo = courseNo;
    }

    public String getCourseNo() 
    {
        return courseNo;
    }
    public void setFile(String file) 
    {
        this.file = file;
    }

    public String getFile() 
    {
        return file;
    }
    public void setIsChecked(String isChecked) 
    {
        this.isChecked = isChecked;
    }

    public String getIsChecked() 
    {
        return isChecked;
    }
    public void setUploadTime(Date uploadTime) 
    {
        this.uploadTime = uploadTime;
    }

    public Date getUploadTime() 
    {
        return uploadTime;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("section", getSection())
            .append("coursewareNo", getCoursewareNo())
            .append("viewCount", getViewCount())
            .append("downloadCount", getDownloadCount())
            .append("uploadAuthor", getUploadAuthor())
            .append("fileSize", getFileSize())
            .append("courseNo", getCourseNo())
            .append("file", getFile())
            .append("isChecked", getIsChecked())
            .append("uploadTime", getUploadTime())
            .append("type", getType())
            .toString();
    }
}
