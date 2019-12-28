package com.dmm.service;

import com.dmm.pojo.Position;
import com.baomidou.mybatisplus.service.IService;
import com.dmm.utils.Page;

/**
 * <p>
 * 职位表 服务类
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface PositionService extends IService<Position> {

    /**
     * 分页
     * @param page
     * @return
     */
    Page<Position> page(Page<Position> page);
}
