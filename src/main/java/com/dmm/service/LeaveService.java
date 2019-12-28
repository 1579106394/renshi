package com.dmm.service;

import com.dmm.pojo.Leave;
import com.baomidou.mybatisplus.service.IService;
import com.dmm.utils.Page;

/**
 * <p>
 * 离职记录表 服务类
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface LeaveService extends IService<Leave> {

    Page<Leave> page(Page<Leave> page);
}
