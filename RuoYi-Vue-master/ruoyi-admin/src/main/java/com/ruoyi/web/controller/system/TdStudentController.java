package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.system.domain.TdTeacher;
import com.ruoyi.system.service.ITdTeacherService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TdStudent;
import com.ruoyi.system.service.ITdStudentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生Controller
 * 
 * @author zhangyan
 * @date 2023-04-23
 */
@RestController
@RequestMapping("/system/student")
public class TdStudentController extends BaseController
{
    @Autowired
    private ITdStudentService tdStudentService;

    @Autowired
    private ITdTeacherService tdTeacherService;

    /**
     * 查询学生列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(TdStudent tdStudent)
    {
        startPage();
        List<TdStudent> list = tdStudentService.selectTdStudentList(tdStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生列表
     */
    @PreAuthorize("@ss.hasPermi('system:student:export')")
    @Log(title = "学生", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TdStudent tdStudent)
    {
        List<TdStudent> list = tdStudentService.selectTdStudentList(tdStudent);
        ExcelUtil<TdStudent> util = new ExcelUtil<TdStudent>(TdStudent.class);
        util.exportExcel(response, list, "学生数据");
    }

    /**
     * 获取学生详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:student:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tdStudentService.selectTdStudentById(id));
    }

    /**
     * 新增学生
     */
    @PreAuthorize("@ss.hasPermi('system:student:add')")
    @Log(title = "学生", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TdStudent tdStudent)
    {
        return toAjax(tdStudentService.insertTdStudent(tdStudent));
    }

    /**
     * 修改学生
     */
    @PreAuthorize("@ss.hasPermi('system:student:edit')")
    @Log(title = "学生", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TdStudent tdStudent)
    {
        return toAjax(tdStudentService.updateTdStudent(tdStudent));
    }

    /**
     * 删除学生
     */
    @PreAuthorize("@ss.hasPermi('system:student:remove')")
    @Log(title = "学生", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tdStudentService.deleteTdStudentByIds(ids));
    }


    @PostMapping("/loginInfo")
    public R login(@RequestBody LoginBody loginBody) {
        R<Object> r = R.ok();
        LambdaQueryWrapper<TdStudent> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TdStudent::getStudentName,loginBody.getUsername());
        TdStudent student = tdStudentService.getOne(queryWrapper);
        if (student == null) {
            //查询教师
            LambdaQueryWrapper<TdTeacher> teacherWrapper = new LambdaQueryWrapper<>();
            teacherWrapper.eq(TdTeacher::getTeacherName,loginBody.getUsername());
            TdTeacher tdTeacher = tdTeacherService.getOne(teacherWrapper);
            if (tdTeacher == null) {
                r.setMsg("查无此人");
                return r;
            }
            if (!tdTeacher.getTeacherPassword().equals(loginBody.getPassword())) {
                r.setMsg("密码不正确");
                return r;
            }
            r.setData(tdTeacher);
            return r;
        }
        if (!student.getStudentPassword().equals(loginBody.getPassword())) {
            r.setMsg("密码不正确");
            return r;
        }
        r.setData(student);
        return r;
    }

}
