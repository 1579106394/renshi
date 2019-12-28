package com.dmm.service;

import com.dmm.pojo.User;
import com.baomidou.mybatisplus.service.IService;
import com.dmm.utils.Page;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public interface UserService extends IService<User> {

    Page<User> page(Page<User> page);
}
