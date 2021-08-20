package com.zhut.wjadmin.module.tag;

import com.zhut.wjadmin.common.domain.ResultVo;
import com.zhut.wjadmin.module.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/indexTags")
    public ResultVo getTags() {
        ResultVo resultVo = null;
        try {
            List<Map<String, Object>> indexTags = tagService.getIndexTags();
            resultVo = ResultVo.success(indexTags);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo = ResultVo.fail("获取失败");
        }
        return resultVo;
    }

}
