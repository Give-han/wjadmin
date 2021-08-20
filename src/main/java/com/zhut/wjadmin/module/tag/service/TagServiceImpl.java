package com.zhut.wjadmin.module.tag.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhut.wjadmin.module.tag.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Map<String, Object>> getIndexTags() {
        List<Map<String, Object>> list = new ArrayList<>();
        // 首页tag类别
        String[] category = {"文学","流行","文化","生活","经管","科技"};
        // 首页每个类别默认展示8个
        for (int i = 0; i < category.length; i++) {
            Map<String, Object> map = new HashMap<>();
            String cate = category[i];
            Page<Map> page = new Page<>();
            page.setSize(8);
            page.setCurrent(1);
            IPage<Map> tagsByCategory = tagMapper.getTagsByCategory(page, cate);
            List<Map> records = tagsByCategory.getRecords();
            map.put("category", cate);
            map.put("tags", records);
            list.add(map);
        }
        return list;
    }
}
