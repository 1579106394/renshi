package com.dmm.controller;

import com.dmm.pojo.Money;
import com.dmm.service.MoneyService;
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
 * 前端控制器
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@Controller
@RequestMapping("/money")
public class MoneyController {

    @Autowired
    private MoneyService moneyService;

    /**
     * 跳转到工资设置
     *
     * @param username
     * @return
     */
    @RequestMapping("/toAdd.action")
    public String toAdd(String username, Model model) {
        model.addAttribute("username", username);
        return "money/money-add";
    }

    /**
     * 工资设置
     *
     * @param money
     * @return
     */
    @RequestMapping("/add.action")
    @ResponseBody
    public R add(@RequestBody Money money) {
        moneyService.insert(money);
        return new R(200, "设置成功！", null);
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping("/list.action")
    public String list(Page<Money> page, Model model) {
        page = moneyService.page(page);
        model.addAttribute("page", page);
        return "money/money-list";
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
        Money money = moneyService.selectById(id);
        model.addAttribute("money", money);
        return "money/money-edit";
    }

    /**
     * 修改
     *
     * @param money
     * @return
     */
    @RequestMapping("/update.action")
    @ResponseBody
    public R update(@RequestBody Money money) {
        moneyService.updateById(money);
        return new R(200, "修改成功！", null);
    }

    /**
     * 删除
     *
     * @param money
     * @return
     */
    @RequestMapping("/delete.action")
    @ResponseBody
    public R delete(@RequestBody Money money) {
        moneyService.deleteById(money.getMoneyId());
        return new R(200, "删除成功！", null);
    }

}

