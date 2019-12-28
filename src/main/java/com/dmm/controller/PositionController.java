package com.dmm.controller;

import com.dmm.pojo.Position;
import com.dmm.service.PositionService;
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
 * 职位表 前端控制器
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@Controller
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping("/list.action")
    public String list(Page<Position> page, Model model) {
        page = positionService.page(page);
        model.addAttribute("page", page);
        return "position/position-list";
    }

    /**
     * 保存
     *
     * @param position
     * @return
     */
    @RequestMapping("/add.action")
    @ResponseBody
    public R add(@RequestBody Position position) {
        positionService.insert(position);
        return new R(200, "保存成功！", null);
    }

    /**
     * 删除
     *
     * @param position
     * @return
     */
    @RequestMapping("/delete.action")
    @ResponseBody
    public R delete(@RequestBody Position position) {
        positionService.deleteById(position.getPositionId());
        return new R(200, "删除成功！", null);
    }

    /**
     * 查询，跳转到修改
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toUpdate.action")
    public String toUpdate(String id, Model model) {
        Position position = positionService.selectById(id);
        model.addAttribute("position", position);
        return "position/position-edit";
    }

    /**
     * 修改
     *
     * @param position
     * @return
     */
    @RequestMapping("/update.action")
    @ResponseBody
    public R update(@RequestBody Position position) {
        positionService.updateById(position);
        return new R(200, "修改成功！", null);
    }

}

