package com.zhut.wjadmin.module.tag.service;

import java.util.List;
import java.util.Map;

public interface TagService {

    /**
     * 获取首页展示标签
     * @return
     */
    List<Map<String, Object>> getIndexTags();
}
