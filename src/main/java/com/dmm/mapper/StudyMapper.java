package com.dmm.mapper;

import com.dmm.pojo.Study;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dmm.utils.Page;

import java.util.List;

/**
 * <p>
 * 培训表 Mapper 接口
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface StudyMapper extends BaseMapper<Study> {

    List<Study> getPage(Page<Study> page);

    int getCount(Page<Study> page);
}
