package com.dmm.mapper;

import com.dmm.pojo.Position;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dmm.utils.Page;

import java.util.List;

/**
 * <p>
 * 职位表 Mapper 接口
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface PositionMapper extends BaseMapper<Position> {

    List<Position> getPage(Page page);

    int getCount(Page page);
}
