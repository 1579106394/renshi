package com.dmm.service;

import com.dmm.pojo.Money;
import com.baomidou.mybatisplus.service.IService;
import com.dmm.utils.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface MoneyService extends IService<Money> {

    Page<Money> page(Page<Money> page);
}
