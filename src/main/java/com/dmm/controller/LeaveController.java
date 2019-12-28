package com.dmm.controller;

import com.dmm.pojo.Leave;
import com.dmm.pojo.User;
import com.dmm.service.LeaveService;
import com.dmm.service.UserService;
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

/**
 * <p>
 * 离职记录表 前端控制器
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private UserService userService;
    @Autowired
    private LeaveService leaveService;

    /**
     * 跳转到离职页
     *
     * @param username
     * @param model
     * @return
     */
    @RequestMapping("/toLeave")
    public String toLeave(String username, Model model) {
        model.addAttribute("username", username);
        return "user/user-leave";
    }

    /**
     * 离职
     *
     * @param leave
     * @return
     */
    @RequestMapping("/leave.action")
    @ResponseBody
    public R leave(@RequestBody Leave leave) {
        // 更新离职信息
        User u = userService.selectById(leave.getLeaveUser());
        u.setLeave(1);
        userService.updateById(u);
        // 记录离职
        leave.setLeaveTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        leaveService.insert(leave);
        return new R(200, "已离职！", null);
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping("/list.action")
    public String list(Page<Leave> page, Model model) {
        page = leaveService.page(page);
        model.addAttribute("page", page);
        return "leave/leave-list";
    }

    /**
     * 删除
     *
     * @param leave
     * @return
     */
    @RequestMapping("/delete.action")
    @ResponseBody
    public R delete(@RequestBody Leave leave) {
        leaveService.deleteById(leave.getLeaveId());
        return new R(200, "删除成功！", null);
    }

    /**
     * 根据id查询
     *
     * @param leave
     * @return
     */
    @RequestMapping("/get.action")
    @ResponseBody
    public R get(@RequestBody Leave leave) {
        return new R(200, "", leaveService.selectById(leave.getLeaveId()));
    }

}

