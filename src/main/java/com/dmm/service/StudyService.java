package com.dmm.service;

import com.dmm.pojo.Study;
import com.baomidou.mybatisplus.service.IService;
import com.dmm.utils.Page;

/**
 * <p>
 * 培训表 服务类
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface StudyService extends IService<Study> {

    Page<Study> page(Page<Study> page);
}
