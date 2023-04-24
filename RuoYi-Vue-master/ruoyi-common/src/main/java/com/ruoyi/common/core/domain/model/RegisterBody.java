package com.ruoyi.common.core.domain.model;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

/**
 * 用户注册对象
 * 
 * @author ruoyi
 */
@Data
public class RegisterBody {

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String no;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 密码 */
    private String password;

    private String grade;

    /**
     * 类型，学生：教师
     */
    private String type;
}
