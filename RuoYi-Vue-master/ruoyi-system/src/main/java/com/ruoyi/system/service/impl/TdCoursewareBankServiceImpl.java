package com.ruoyi.system.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TdCoursewareBankMapper;
import com.ruoyi.system.domain.TdCoursewareBank;
import com.ruoyi.system.service.ITdCoursewareBankService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 课程库Service业务层处理
 * 
 * @author zhangyan
 * @date 2023-04-24
 */
@Service
public class TdCoursewareBankServiceImpl implements ITdCoursewareBankService 
{

    @Autowired
    private TdCoursewareBankMapper tdCoursewareBankMapper;

    /**
     * 查询课程库
     * 
     * @param id 课程库主键
     * @return 课程库
     */
    @Override
    public TdCoursewareBank selectTdCoursewareBankById(Long id)
    {
        return tdCoursewareBankMapper.selectTdCoursewareBankById(id);
    }

    /**
     * 查询课程库列表
     * 
     * @param tdCoursewareBank 课程库
     * @return 课程库
     */
    @Override
    public List<TdCoursewareBank> selectTdCoursewareBankList(TdCoursewareBank tdCoursewareBank)
    {
        return tdCoursewareBankMapper.selectTdCoursewareBankList(tdCoursewareBank);
    }

    /**
     * 新增课程库
     * 
     * @param tdCoursewareBank 课程库
     * @return 结果
     */
    @Override
    public int insertTdCoursewareBank(TdCoursewareBank tdCoursewareBank)
    {
        return tdCoursewareBankMapper.insertTdCoursewareBank(tdCoursewareBank);
    }

    /**
     * 修改课程库
     * 
     * @param tdCoursewareBank 课程库
     * @return 结果
     */
    @Override
    public int updateTdCoursewareBank(TdCoursewareBank tdCoursewareBank)
    {
        return tdCoursewareBankMapper.updateTdCoursewareBank(tdCoursewareBank);
    }

    /**
     * 批量删除课程库
     * 
     * @param ids 需要删除的课程库主键
     * @return 结果
     */
    @Override
    public int deleteTdCoursewareBankByIds(Long[] ids)
    {
        return tdCoursewareBankMapper.deleteTdCoursewareBankByIds(ids);
    }

    /**
     * 删除课程库信息
     * 
     * @param id 课程库主键
     * @return 结果
     */
    @Override
    public int deleteTdCoursewareBankById(Long id)
    {
        return tdCoursewareBankMapper.deleteTdCoursewareBankById(id);
    }

    @Override
    public void downloadFile(Long id,String profile) throws FileNotFoundException {
        //根据库id查询当前数据
        TdCoursewareBank tdCoursewareBank = selectTdCoursewareBankById(id);
        String file = tdCoursewareBank.getFile();
        //获取文件名
        String[] split = file.split("/");
        String fileName = split[split.length - 1];
        //组装文件路径
        String fileLocal = file.replace("/profile", profile);
        ServletRequestAttributes servletRequestAttributes =  (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        downloadLocal(response,fileName,fileLocal);
    }

    public void downloadLocal(HttpServletResponse response,String fileName,String fileLocal) throws FileNotFoundException {

        // 下载本地文件

        // 文件的默认保存名

        // 读到流中

        InputStream inStream = new FileInputStream(fileLocal);// 文件的存放路径

        // 设置输出的格式

        response.reset();

        response.setContentType("bin");

        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        // 循环取出流中的数据

        byte[] b = new byte[100];

        int len;

        try {

            while ((len = inStream.read(b)) > 0)

                response.getOutputStream().write(b, 0, len);

            inStream.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}