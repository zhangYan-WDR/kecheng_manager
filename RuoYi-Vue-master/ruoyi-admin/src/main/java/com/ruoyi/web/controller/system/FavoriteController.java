package com.ruoyi.web.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.Favorite;
import com.ruoyi.system.domain.TdCoursewareBank;
import com.ruoyi.system.mapper.TdCoursewareBankMapper;
import com.ruoyi.system.service.FavoriteService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Resource
    private FavoriteService favoriteService;

    @Autowired
    private TdCoursewareBankMapper tdCoursewareBankMapper;

    @PostMapping("/save")
    public R saveFavorite(@RequestBody Favorite favorite){
        LambdaQueryWrapper<Favorite> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Favorite::getUserId, favorite.getUserId());
        wrapper.eq(Favorite::getCoursewareBankId, favorite.getCoursewareBankId());
        Favorite one = favoriteService.getOne(wrapper);
        if (one == null) {
            //保存
            one = new Favorite();
            one.setUserId(favorite.getUserId());
            one.setCoursewareBankId(favorite.getCoursewareBankId());
            favoriteService.save(one);
        }else {
            //删除
            favoriteService.removeById(one.getId());
        }
        R<Object> ok = R.ok();
        ok.setMsg("保存更改成功");
        return ok;
    }

    @GetMapping("/getFavorite")
    public R getFavorite(@RequestParam("userId") Integer userId, @RequestParam("coursewareBankId")Integer coursewareBankId){
        LambdaQueryWrapper<Favorite> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Favorite::getUserId, userId);
        wrapper.eq(Favorite::getCoursewareBankId, coursewareBankId);
        Favorite one = favoriteService.getOne(wrapper);
        R<Object> ok = R.ok();
        if (one == null) {
            //保存
            ok.setMsg("未收藏");
            ok.setData(false);
        }else {
            //删除
            ok.setMsg("已收藏");
            ok.setData(true);
        }
        return ok;
    }

    @GetMapping("/list")
    public R getFavorite(@RequestParam("userId") Integer userId){
        LambdaQueryWrapper<Favorite> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Favorite::getUserId, userId);
        List<Favorite> list = favoriteService.list(wrapper);
        ArrayList<TdCoursewareBank> tdCoursewareBanks = new ArrayList<>();
        for (Favorite favorite : list) {
            TdCoursewareBank tdCoursewareBank = tdCoursewareBankMapper.selectTdCoursewareBankById(Long.valueOf(favorite.getCoursewareBankId()));
            tdCoursewareBanks.add(tdCoursewareBank);
        }
        R<Object> ok = R.ok();
        ok.setMsg("已收藏");
        ok.setData(tdCoursewareBanks);
        return ok;
    }

}
