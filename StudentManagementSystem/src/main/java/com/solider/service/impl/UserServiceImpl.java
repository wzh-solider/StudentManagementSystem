package com.solider.service.impl;

import com.solider.bean.User;
import com.solider.exception.ApplicationException;
import com.solider.mapper.UserMapper;
import com.solider.service.UserService;
import com.solider.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Solider
 * @version 2.0
 * @since 1.0
 */
public class UserServiceImpl implements UserService {

    @Override
    public User checkUser(String email, String password) {
        // 访问数据库，进行验证
        UserMapper mapper = SqlSessionUtil.openSession().getMapper(UserMapper.class);
        User user = mapper.checkUser(email, password);
        SqlSessionUtil.close();
        return user;
    }

    @Override
    public boolean signUp(User user) {
        // 进行注册
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = 0;
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            count = mapper.SignUpUser(user);
            // 判断数据是否注册
            if (count < 0) {
                throw new ApplicationException("User sign up failed");
            }
            // 提交事务
            sqlSession.commit();
        } catch (ApplicationException e) {
            e.printStackTrace();
            // 发生异常，将事务回滚
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return count > 0;
    }
}
