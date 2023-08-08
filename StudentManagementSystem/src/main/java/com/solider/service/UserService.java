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
     * @param request
     * @param response
     * @return
     */
    User checkUser(HttpServletRequest request, HttpServletResponse response);

    /**
     * 用户注册
     * @param request
     * @param response
     * @return
     */
    boolean signUp(HttpServletRequest request, HttpServletResponse response);
}
