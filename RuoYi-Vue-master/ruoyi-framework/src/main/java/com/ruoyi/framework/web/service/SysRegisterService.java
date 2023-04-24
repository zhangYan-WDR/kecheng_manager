package com.ruoyi.framework.web.service;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.system.mapper.SysRoleMapper;
import com.ruoyi.system.service.ITdStudentService;
import com.ruoyi.system.service.ITdTeacherService;
import com.ruoyi.system.service.impl.TdStudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.RegisterBody;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.exception.user.CaptchaException;
import com.ruoyi.common.exception.user.CaptchaExpireException;
import com.ruoyi.common.utils.MessageUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.manager.AsyncManager;
import com.ruoyi.framework.manager.factory.AsyncFactory;
import com.ruoyi.system.service.ISysConfigService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 注册校验方法
 * 
 * @author ruoyi
 */
@Component
public class SysRegisterService
{
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ITdStudentService tdStudentService;

    @Autowired
    private ITdTeacherService tdTeacherService;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 注册
     */
    @Transactional
    public String register(RegisterBody registerBody)
    {
        String msg = "", username = registerBody.getName(), password = registerBody.getPassword();
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);
        sysUser.setEmail(registerBody.getEmail());
        sysUser.setPhonenumber(registerBody.getPhone());
        sysUser.setNickName(registerBody.getNo());

        if (StringUtils.isEmpty(username))
        {
            msg = "用户名不能为空";
        }
        else if (StringUtils.isEmpty(password))
        {
            msg = "用户密码不能为空";
        }
        else if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            msg = "账户长度必须在2到20个字符之间";
        }
        else if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            msg = "密码长度必须在5到20个字符之间";
        }
        else if (!userService.checkUserNameUnique(sysUser))
        {
            msg = "保存用户'" + username + "'失败，注册账号已存在";
        } else if (!userService.checkEmailUnique(sysUser)) {
            msg = "保存用户'" + sysUser.getEmail() + "'失败，邮箱已被使用";
        } else if (!userService.checkPhoneUnique(sysUser)) {
            msg = "保存用户'" + sysUser.getPhonenumber() + "'失败，手机号已被注册";
        } else if (!userService.checkPhoneUnique(sysUser)) {
            msg = "保存用户'" + sysUser.getPhonenumber() + "'失败，手机号已被注册";
        } else if (!userService.checkNoUnique(sysUser)) {
            msg = "保存用户'" + sysUser.getNickName() + "'失败，身份证号已被注册";
        } else {
            sysUser.setNickName(username);
            sysUser.setPassword(SecurityUtils.encryptPassword(password));
            sysUser.setEmail(registerBody.getEmail());
            sysUser.setPhonenumber(registerBody.getPhone());
            if (registerBody.getSex().equals("男")) {
                sysUser.setSex("0");
            } else if (registerBody.getSex().equals("女")) {
                sysUser.setSex("1");
            } else {
                sysUser.setSex("2");
            }
            sysUser.setNickName(registerBody.getNo());
            sysUser.setStatus("0");
            sysUser.setDelFlag("0");

            boolean regFlag = userService.registerUser(sysUser);
            if (!regFlag) {
                msg = "注册失败,请联系系统管理人员";
            } else {
                //生成用户表
                if (registerBody.getType().equals("学生")) {
                    tdStudentService.saveByType(registerBody);
                } else if (registerBody.getType().equals("教师")) {
                    tdTeacherService.saveByType(registerBody);
                }
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.REGISTER, MessageUtils.message("user.register.success")));
            }
        }
        return msg;
    }

    /**
     * 校验验证码
     * 
     * @param username 用户名
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public void validateCaptcha(String username, String code, String uuid)
    {
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null)
        {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha))
        {
            throw new CaptchaException();
        }
    }
}
