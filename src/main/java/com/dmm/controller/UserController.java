package com.dmm.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dmm.pojo.Money;
import com.dmm.pojo.Position;
import com.dmm.pojo.PostionChange;
import com.dmm.pojo.User;
import com.dmm.service.LeaveService;
import com.dmm.service.MoneyService;
import com.dmm.service.PositionService;
import com.dmm.service.PostionChangeService;
import com.dmm.service.UserService;
import com.dmm.utils.Page;
import com.dmm.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private PostionChangeService changeService;
    @Autowired
    private LeaveService leaveService;
    @Autowired
    private MoneyService moneyService;

    /**
     * 登录
     *
     * @param user
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/login.action")
    public String login(User user, Model model, HttpSession session) {
        User u = userService.selectById(user.getUsername());
        if (u == null) {
            model.addAttribute("err", "用户名或密码错误");
            return "login";
        }
        if (!u.getPassword().equals(user.getPassword())) {
            model.addAttribute("err", "用户名或密码错误");
            return "login";
        }
        session.setAttribute("user", u);
        return "index";
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout.action")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping("/list.action")
    public String list(Page<User> page, Model model) {
        page = userService.page(page);
        model.addAttribute("page", page);
        return "user/user-list";
    }

    /**
     * 保存
     *
     * @param user
     * @return
     */
    @RequestMapping("/add.action")
    @ResponseBody
    public R add(@RequestBody User user) {
        userService.insert(user);
        return new R(200, "保存成功！", null);
    }

    /**
     * 删除
     *
     * @param user
     * @return
     */
    @RequestMapping("/delete.action")
    @ResponseBody
    public R delete(@RequestBody User user) {
        userService.deleteById(user.getUsername());
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
        User user = userService.selectById(id);
        List<Position> positions = positionService.selectList(new EntityWrapper<>());
        model.addAttribute("positionList", positions);
        model.addAttribute("user", user);
        return "user/user-edit";
    }

    /**
     * 根据id查询
     *
     * @param user
     * @return
     */
    @RequestMapping("/get.action")
    @ResponseBody
    public R get(@RequestBody User user) {
        return new R(200, "", userService.selectById(user.getUsername()));
    }

    /**
     * 查询，跳转到添加
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toAdd.action")
    public String toAdd(String id, Model model) {
        List<Position> positions = positionService.selectList(new EntityWrapper<>());
        model.addAttribute("positionList", positions);
        return "user/user-add";
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    @RequestMapping("/update.action")
    @ResponseBody
    public R update(@RequestBody User user) {
        User oldUser = userService.selectById(user.getUsername());
        if (oldUser.getPosition() != null && !oldUser.getPosition().equals(user.getPosition())) {
            // 职位变动了，添加职位变动记录
            PostionChange postionChange = new PostionChange();
            postionChange.setChangeOldPosition(oldUser.getPosition());
            postionChange.setChangeNewPosition(user.getPosition());
            postionChange.setChangeUser(user.getUsername());
            postionChange.setChangeTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            changeService.insert(postionChange);
        }
        userService.updateById(user);
        return new R(200, "修改成功！", null);
    }

    /**
     * 转正
     *
     * @param user
     * @return
     */
    @RequestMapping("/formal.action")
    @ResponseBody
    public R formal(@RequestBody User user) {
        User u = userService.selectById(user.getUsername());
        u.setFormal(1);
        u.setFormalTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        userService.updateById(u);
        // 查询该用户工资条，折扣改为1
        Money money = moneyService.selectOne(new EntityWrapper<Money>().eq("money_user", user.getUsername()));
        if (money != null) {
            money.setMoneyDiscount(new BigDecimal(1));
            moneyService.updateById(money);
        }
        return new R(200, "转正成功！", null);
    }

}

