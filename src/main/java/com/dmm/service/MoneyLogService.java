package com.dmm.service;

import com.dmm.pojo.MoneyLog;
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
public interface MoneyLogService extends IService<MoneyLog> {

    Page<MoneyLog> page(Page<MoneyLog> page);
}
