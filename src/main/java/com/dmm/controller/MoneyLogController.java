package com.dmm.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dmm.pojo.Money;
import com.dmm.pojo.MoneyLog;
import com.dmm.service.MoneyLogService;
import com.dmm.service.MoneyService;
import com.dmm.utils.Page;
import com.dmm.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@Controller
@RequestMapping("/moneyLog")
public class MoneyLogController {

    @Autowired
    private MoneyService moneyService;
    @Autowired
    private MoneyLogService moneyLogService;

    /**
     * 给每位员工发工资
     *
     * @return
     */
    @RequestMapping("/addAll.action")
    @ResponseBody
    public R addAll() {
        // 获取当月
        String nowMonth = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        // 先查询本月是否已经发过工资
        List<MoneyLog> list = moneyLogService.selectList(new EntityWrapper<MoneyLog>().eq("log_time", nowMonth));
        // 查询所有有工资的用户
        List<Money> moneyList = moneyService.selectList(new EntityWrapper<>());
        List<MoneyLog> moneyLogList = new ArrayList<>();
        for (Money money : moneyList) {
            MoneyLog moneyLog = new MoneyLog();
            moneyLog.setLogMoney(money.getMoneyPrice().multiply(money.getMoneyDiscount()));
            moneyLog.setLogUser(money.getMoneyUser());
            moneyLog.setLogTime(nowMonth);
            if (list == null || !list.contains(moneyLog)) {
                moneyLogList.add(moneyLog);
            }
        }
        moneyLogService.insertBatch(moneyLogList);
        return new R(200, "发放成功", null);
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping("/list.action")
    public String list(Page<MoneyLog> page, Model model) {
        page = moneyLogService.page(page);
        model.addAttribute("page", page);
        return "moneyLog/moneyLog-list";
    }

    /**
     * 删除
     *
     * @param money
     * @return
     */
    @RequestMapping("/delete.action")
    @ResponseBody
    public R delete(@RequestBody MoneyLog money) {
        moneyLogService.deleteById(money.getLogId());
        return new R(200, "删除成功！", null);
    }

}

