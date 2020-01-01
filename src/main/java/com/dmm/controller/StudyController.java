package com.dmm.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dmm.pojo.Study;
import com.dmm.pojo.User;
import com.dmm.service.StudyService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 培训表 前端控制器
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@Controller
@RequestMapping("/study")
public class StudyController {

    @Autowired
    private StudyService studyService;
    @Autowired
    private UserService userService;

    /**
     * 查询用户，跳转到添加学习
     *
     * @param model
     * @return
     */
    @RequestMapping("/toStudy.action")
    public String toStudy(Model model) {
        List<User> userList = userService.selectList(new EntityWrapper<>());
        model.addAttribute("userList", userList);
        return "study/study-add";
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping("/list.action")
    public String list(Page<Study> page, Model model) {
        page = studyService.page(page);
        model.addAttribute("page", page);
        return "study/study-list";
    }

    /**
     * 保存
     *
     * @param study
     * @return
     */
    @RequestMapping("/add.action")
    @ResponseBody
    public R add(@RequestBody Study study) {
        study.setStudyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        studyService.insert(study);
        return new R(200, "保存成功！", null);
    }

    /**
     * 删除
     *
     * @param study
     * @return
     */
    @RequestMapping("/delete.action")
    @ResponseBody
    public R delete(@RequestBody Study study) {
        studyService.deleteById(study.getStudyId());
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
        Study study = studyService.selectById(id);
        String studyUser = study.getStudyUser();
        if (studyUser != null) {
            String[] strings = studyUser.split("','");
            List<String> userIds = new ArrayList<>();
            for (String string : strings) {
                userIds.add(string.replace("'", ""));
            }
            List<User> userList = userService.selectList(new EntityWrapper<User>().in("username", userIds));
            study.setUserList(userList);
        }
        List<User> userList = userService.selectList(new EntityWrapper<>());
        model.addAttribute("userList", userList);
        model.addAttribute("study", study);
        return "study/study-edit";
    }

    /**
     * 根据id查询
     *
     * @param study
     * @return
     */
    @RequestMapping("/get.action")
    @ResponseBody
    public R get(@RequestBody Study study) {
        study = studyService.selectById(study.getStudyId());
        String studyUser = study.getStudyUser();
        if (studyUser != null) {
            String[] strings = studyUser.split("','");
            List<String> userIds = new ArrayList<>();
            for (String string : strings) {
                userIds.add(string.replace("'", ""));
            }
            List<User> userList = userService.selectList(new EntityWrapper<User>().in("username", userIds));
            study.setUserList(userList);
        }
        return new R(200, "", study);
    }

    /**
     * 修改
     *
     * @param study
     * @return
     */
    @RequestMapping("/update.action")
    @ResponseBody
    public R update(@RequestBody Study study) {
        studyService.updateById(study);
        return new R(200, "修改成功！", null);
    }
}

