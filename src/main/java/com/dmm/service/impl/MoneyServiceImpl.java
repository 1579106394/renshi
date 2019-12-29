package com.dmm.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dmm.mapper.MoneyMapper;
import com.dmm.pojo.Money;
import com.dmm.service.MoneyService;
import com.dmm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
@Service
public class MoneyServiceImpl extends ServiceImpl<MoneyMapper, Money> implements MoneyService {

    @Autowired
    private MoneyMapper moneyMapper;

    @Override
    public Page<Money> page(Page<Money> page) {
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
        List<Money> list = baseMapper.getPage(page);
        int count = baseMapper.getCount(page);
        page.setList(list);
        page.setTotalCount(count);
        page.setTotalPage((int) Math.ceil(count * 1.0 / page.getCurrentCount()));
        return page;
    }
}
