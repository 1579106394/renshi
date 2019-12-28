package com.dmm.service;

import com.dmm.pojo.PostionChange;
import com.baomidou.mybatisplus.service.IService;
import com.dmm.utils.Page;

/**
 * <p>
 * 职位变更记录 服务类
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface PostionChangeService extends IService<PostionChange> {

    Page<PostionChange> page(Page<PostionChange> page);
}
