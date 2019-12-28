package com.dmm.mapper;

import com.dmm.pojo.PostionChange;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dmm.utils.Page;

import java.util.List;

/**
 * <p>
 * 职位变更记录 Mapper 接口
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface PostionChangeMapper extends BaseMapper<PostionChange> {

    List<PostionChange> getPage(Page<PostionChange> page);

    int getCount(Page<PostionChange> page);
}
