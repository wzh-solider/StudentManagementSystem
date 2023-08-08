package com.solider.service.impl;

import com.solider.bean.User;
import com.solider.mapper.UserMapper;
import com.solider.service.UserService;
import com.solider.utils.SqlSessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
public class UserServiceImpl implements UserService {

    @Override
    public User checkUser(HttpServletRequest request, HttpServletResponse response) {
        // 获取参数
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // 访问数据库，进行验证
        UserMapper mapper = SqlSessionUtil.openSession().getMapper(UserMapper.class);
        return mapper.checkUser(email, password);
    }

    @Override
    public boolean signUp(HttpServletRequest request, HttpServletResponse response) {
        // 获取用户注册的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // 进行注册
        UserMapper mapper = SqlSessionUtil.openSession().getMapper(UserMapper.class);
        return mapper.SignUpUser(username, email, password) > 0;
    }
}
