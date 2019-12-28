package com.dmm.mapper;

import com.dmm.pojo.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dmm.utils.Page;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface UserMapper extends BaseMapper<User> {

    int getCount(Page<User> page);

    List<User> getPage(Page<User> page);
}
