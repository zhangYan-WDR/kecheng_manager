package com.ruoyi.web.controller.system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.NoUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TdCoursewareBank;
import com.ruoyi.system.service.ITdCoursewareBankService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程库Controller
 * 
 * @author zhangyan
 * @date 2023-04-24
 */
@RestController
@RequestMapping("/system/bank")
public class TdCoursewareBankController extends BaseController
{
    @Autowired
    private ITdCoursewareBankService tdCoursewareBankService;

    @Value("${ruoyi.profile}")
    private String profile;

    /**
     * 查询课程库列表
     */
    @PreAuthorize("@ss.hasPermi('system:bank:list')")
    @GetMapping("/list")
    public TableDataInfo list(TdCoursewareBank tdCoursewareBank)
    {
        startPage();
        List<TdCoursewareBank> list = tdCoursewareBankService.selectTdCoursewareBankList(tdCoursewareBank);
        return getDataTable(list);
    }

    /**
     * 导出课程库列表
     */
    @PreAuthorize("@ss.hasPermi('system:bank:export')")
    @Log(title = "课程库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TdCoursewareBank tdCoursewareBank)
    {
        List<TdCoursewareBank> list = tdCoursewareBankService.selectTdCoursewareBankList(tdCoursewareBank);
        ExcelUtil<TdCoursewareBank> util = new ExcelUtil<TdCoursewareBank>(TdCoursewareBank.class);
        util.exportExcel(response, list, "课程库数据");
    }

    /**
     * 获取课程库详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:bank:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tdCoursewareBankService.selectTdCoursewareBankById(id));
    }

    /**
     * 新增课程库
     */
    @PreAuthorize("@ss.hasPermi('system:bank:add')")
    @Log(title = "课程库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TdCoursewareBank tdCoursewareBank)
    {
        tdCoursewareBank.setUploadAuthor(getUsername());
        return toAjax(tdCoursewareBankService.insertTdCoursewareBank(tdCoursewareBank,profile));
    }

    /**
     * 修改课程库
     */
    @PreAuthorize("@ss.hasPermi('system:bank:edit')")
    @Log(title = "课程库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TdCoursewareBank tdCoursewareBank)
    {
        return toAjax(tdCoursewareBankService.updateTdCoursewareBank(tdCoursewareBank));
    }

    /**
     * 删除课程库
     */
    @PreAuthorize("@ss.hasPermi('system:bank:remove')")
    @Log(title = "课程库", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tdCoursewareBankService.deleteTdCoursewareBankByIds(ids));
    }

    /**
     * 审核课程库成功
     */
    @PreAuthorize("@ss.hasPermi('system:bank:check')")
    @Log(title = "课程库", businessType = BusinessType.CHECK)
    @PostMapping("check/{ids}")
    public AjaxResult check(@PathVariable Long[] ids)
    {
        return toAjax(tdCoursewareBankService.checkTdCoursewareBankByIds(ids,"成功"));
    }

    /**
     * 审核课程库失败
     * @param ids
     * @return
     */
    @PreAuthorize("@ss.hasPermi('system:bank:check')")
    @Log(title = "课程库", businessType = BusinessType.CHECK)
    @PostMapping("checkFail/{ids}")
    public AjaxResult checkFail(@PathVariable Long[] ids)
    {
        return toAjax(tdCoursewareBankService.checkTdCoursewareBankByIds(ids,"驳回"));
    }

    @GetMapping("/download")
    public void downloadFile(@RequestParam("id") Long id) throws FileNotFoundException {
        tdCoursewareBankService.downloadFile(id,profile);
    }

    @GetMapping("/view")
    public void viewFile(@RequestParam("id") Long id) throws FileNotFoundException {
        tdCoursewareBankService.viewFile(id);
    }

}
