package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("td_favorite")
@Data
public class Favorite {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer coursewareBankId;

}
