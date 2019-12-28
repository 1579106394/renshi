package com.dmm.mapper;

import com.dmm.pojo.Leave;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dmm.utils.Page;

import java.util.List;

/**
 * <p>
 * 离职记录表 Mapper 接口
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface LeaveMapper extends BaseMapper<Leave> {

    List<Leave> getPage(Page<Leave> page);

    int getCount(Page<Leave> page);
}
