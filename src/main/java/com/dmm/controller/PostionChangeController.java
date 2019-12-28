package com.dmm.controller;

import com.dmm.pojo.PostionChange;
import com.dmm.service.PostionChangeService;
import com.dmm.utils.Page;
import com.dmm.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 职位变更记录 前端控制器
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@Controller
@RequestMapping("/postionChange")
public class PostionChangeController {

    @Autowired
    private PostionChangeService postionChangeService;

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping("/list.action")
    public String list(Page<PostionChange> page, Model model) {
        page = postionChangeService.page(page);
        model.addAttribute("page", page);
        return "change/change-list";
    }

    /**
     * 删除
     *
     * @param change
     * @return
     */
    @RequestMapping("/delete.action")
    @ResponseBody
    public R delete(@RequestBody PostionChange change) {
        postionChangeService.deleteById(change.getChangeId());
        return new R(200, "删除成功！", null);
    }
}

