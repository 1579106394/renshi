package com.dmm.mapper;

import com.dmm.pojo.Recruitment;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dmm.utils.Page;

import java.util.List;

/**
 * <p>
 * 招聘表 Mapper 接口
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface RecruitmentMapper extends BaseMapper<Recruitment> {

    List<Recruitment> getPage(Page<Recruitment> page);

    int getCount(Page<Recruitment> page);
}
