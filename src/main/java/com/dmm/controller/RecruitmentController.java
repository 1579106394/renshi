package com.dmm.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dmm.pojo.Position;
import com.dmm.pojo.Recruitment;
import com.dmm.service.PositionService;
import com.dmm.service.RecruitmentService;
import com.dmm.utils.Page;
import com.dmm.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 招聘表 前端控制器
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@Controller
@RequestMapping("/recruitment")
public class RecruitmentController {

    @Autowired
    private RecruitmentService recruitmentService;
    @Autowired
    private PositionService positionService;

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping("/list.action")
    public String list(Page<Recruitment> page, Model model) {
        page = recruitmentService.page(page);
        model.addAttribute("page", page);
        return "recruitment/recruitment-list";
    }

    /**
     * 保存
     *
     * @param recruitment
     * @return
     */
    @RequestMapping("/add.action")
    @ResponseBody
    public R add(@RequestBody Recruitment recruitment) {
        recruitment.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        recruitmentService.insert(recruitment);
        return new R(200, "保存成功！", null);
    }

    /**
     * 删除
     *
     * @param recruitment
     * @return
     */
    @RequestMapping("/delete.action")
    @ResponseBody
    public R delete(@RequestBody Recruitment recruitment) {
        recruitmentService.deleteById(recruitment.getId());
        return new R(200, "删除成功！", null);
    }

    /**
     * 删除
     *
     * @param recruitment
     * @return
     */
    @RequestMapping("/end.action")
    @ResponseBody
    public R end(@RequestBody Recruitment recruitment) {
        Recruitment r = recruitmentService.selectById(recruitment.getId());
        r.setStatus(1);
        recruitmentService.updateById(r);
        return new R(200, "已结束！", null);
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
        Recruitment recruitment = recruitmentService.selectById(id);
        List<Position> positions = positionService.selectList(new EntityWrapper<>());
        model.addAttribute("positionList", positions);
        model.addAttribute("recruitment", recruitment);
        return "recruitment/recruitment-edit";
    }

    /**
     * 查询，跳转到添加
     *
     * @param model
     * @return
     */
    @RequestMapping("/toAdd.action")
    public String toAdd(Model model) {
        List<Position> positions = positionService.selectList(new EntityWrapper<>());
        model.addAttribute("positionList", positions);
        return "recruitment/recruitment-add";
    }

    /**
     * 根据id查询
     *
     * @param recruitment
     * @return
     */
    @RequestMapping("/get.action")
    @ResponseBody
    public R get(@RequestBody Recruitment recruitment) {
        return new R(200, "", recruitmentService.selectById(recruitment.getId()));
    }

    /**
     * 修改
     *
     * @param recruitment
     * @return
     */
    @RequestMapping("/update.action")
    @ResponseBody
    public R update(@RequestBody Recruitment recruitment) {
        recruitmentService.updateById(recruitment);
        return new R(200, "修改成功！", null);
    }
}

