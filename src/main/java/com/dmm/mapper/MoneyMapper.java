package com.dmm.mapper;

import com.dmm.pojo.Money;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dmm.utils.Page;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface MoneyMapper extends BaseMapper<Money> {

    List<Money> getPage(Page<Money> page);

    int getCount(Page<Money> page);
}
