package com.dmm.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dmm.mapper.PositionMapper;
import com.dmm.mapper.PostionChangeMapper;
import com.dmm.pojo.Leave;
import com.dmm.pojo.PostionChange;
import com.dmm.service.PostionChangeService;
import com.dmm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 职位变更记录 服务实现类
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@Service
public class PostionChangeServiceImpl extends ServiceImpl<PostionChangeMapper, PostionChange> implements PostionChangeService {

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public Page<PostionChange> page(Page<PostionChange> page) {
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
        List<PostionChange> list = baseMapper.getPage(page);
        int count = baseMapper.getCount(page);
        page.setList(list);
        page.setTotalCount(count);
        page.setTotalPage((int) Math.ceil(count * 1.0 / page.getCurrentCount()));
        return page;
    }
}
