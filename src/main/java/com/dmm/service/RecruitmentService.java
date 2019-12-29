package com.dmm.service;

import com.dmm.pojo.Recruitment;
import com.baomidou.mybatisplus.service.IService;
import com.dmm.utils.Page;

/**
 * <p>
 * 招聘表 服务类
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface RecruitmentService extends IService<Recruitment> {

    Page<Recruitment> page(Page<Recruitment> page);
}
