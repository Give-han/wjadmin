package com.zhut.wjadmin.module.tag.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhut.wjadmin.common.domain.Base;
import lombok.Data;

@Data
@TableName("tag")
public class Tag extends Base {

    // id: UUID
    @TableId(value = "tag_id", type = IdType.ASSIGN_UUID)
    private String tagId;

    @TableField("tag_name")
    private String tagName;

    private String category;
}
