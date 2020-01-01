package com.dmm.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dmm.mapper.StudyMapper;
import com.dmm.mapper.UserMapper;
import com.dmm.pojo.Study;
import com.dmm.pojo.User;
import com.dmm.service.StudyService;
import com.dmm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 培训表 服务实现类
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@Service
public class StudyServiceImpl extends ServiceImpl<StudyMapper, Study> implements StudyService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<Study> page(Page<Study> page) {
        Integer currentCount = page.getCurrentCount();
        if (currentCount == null) {
            currentCount = 10;
            page.setCurrentCount(currentCount);
        }
        Integer currentPage = page.getCurrentPage();
        if (currentPage == null || currentPage < 1) {
            currentPage = 1;
            page.setCurrentPage(currentPage);
        }
        page.setIndex((currentPage - 1) * currentCount);
        List<Study> list = baseMapper.getPage(page);
        for (Study study : list) {
            String studyUser = study.getStudyUser();
            if (studyUser != null) {
                String[] strings = studyUser.split("','");
                List<String> userIds = new ArrayList<>();
                for (String string : strings) {
                    userIds.add(string.replace("'",""));
                }
                List<User> userList = userMapper.selectList(new EntityWrapper<User>().in("username", userIds));
                study.setUserList(userList);
            }
        }

        int count = baseMapper.getCount(page);
        page.setList(list);
        page.setTotalCount(count);
        page.setTotalPage((int) Math.ceil(count * 1.0 / page.getCurrentCount()));
        return page;
    }
}
