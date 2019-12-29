package com.dmm.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dmm.mapper.RecruitmentMapper;
import com.dmm.pojo.Recruitment;
import com.dmm.service.RecruitmentService;
import com.dmm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 招聘表 服务实现类
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@Service
public class RecruitmentServiceImpl extends ServiceImpl<RecruitmentMapper, Recruitment> implements RecruitmentService {

    @Autowired
    private RecruitmentMapper recruitmentMapper;

    @Override
    public Page<Recruitment> page(Page<Recruitment> page) {
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
        List<Recruitment> list = baseMapper.getPage(page);
        int count = baseMapper.getCount(page);
        page.setList(list);
        page.setTotalCount(count);
        page.setTotalPage((int) Math.ceil(count * 1.0 / page.getCurrentCount()));
        return page;
    }
}
