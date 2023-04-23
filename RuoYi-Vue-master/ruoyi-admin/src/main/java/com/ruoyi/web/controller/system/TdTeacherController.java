package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.TdTeacher;
import com.ruoyi.system.service.ITdTeacherService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师管理Controller
 * 
 * @author ruoyi
 * @date 2023-04-23
 */
@RestController
@RequestMapping("/system/teacher")
public class TdTeacherController extends BaseController
{
    @Autowired
    private ITdTeacherService tdTeacherService;

    /**
     * 查询教师管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:list')")
    @GetMapping("/list")
    public TableDataInfo list(TdTeacher tdTeacher)
    {
        startPage();
        List<TdTeacher> list = tdTeacherService.selectTdTeacherList(tdTeacher);
        return getDataTable(list);
    }

    /**
     * 导出教师管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:export')")
    @Log(title = "教师管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TdTeacher tdTeacher)
    {
        List<TdTeacher> list = tdTeacherService.selectTdTeacherList(tdTeacher);
        ExcelUtil<TdTeacher> util = new ExcelUtil<TdTeacher>(TdTeacher.class);
        util.exportExcel(response, list, "教师管理数据");
    }

    /**
     * 获取教师管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tdTeacherService.selectTdTeacherById(id));
    }

    /**
     * 新增教师管理
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:add')")
    @Log(title = "教师管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TdTeacher tdTeacher)
    {
        return toAjax(tdTeacherService.insertTdTeacher(tdTeacher));
    }

    /**
     * 修改教师管理
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:edit')")
    @Log(title = "教师管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TdTeacher tdTeacher)
    {
        return toAjax(tdTeacherService.updateTdTeacher(tdTeacher));
    }

    /**
     * 删除教师管理
     */
    @PreAuthorize("@ss.hasPermi('system:teacher:remove')")
    @Log(title = "教师管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tdTeacherService.deleteTdTeacherByIds(ids));
    }
}
