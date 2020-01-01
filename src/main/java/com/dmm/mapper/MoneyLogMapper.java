package com.dmm.mapper;

import com.dmm.pojo.MoneyLog;
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
public interface MoneyLogMapper extends BaseMapper<MoneyLog> {

    List<MoneyLog> getPage(Page<MoneyLog> page);

    int getCount(Page<MoneyLog> page);
}
