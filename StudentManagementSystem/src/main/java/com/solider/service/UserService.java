package com.solider.service;

import com.solider.bean.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
public interface UserService {

    /**
     * 用户登录验证
     * @param email 邮箱
     * @param password 密码
     * @return 用户对象
     */
    User checkUser(String email, String password);

    /**
     * 用户注册
     * @param user 用户数据
     * @return boolean
     */
    boolean signUp(User user);
}
