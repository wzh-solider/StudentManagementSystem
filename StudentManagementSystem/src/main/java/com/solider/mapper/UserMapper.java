package com.solider.mapper;

import com.solider.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
public interface UserMapper {

    /**
     * 用户登录验证
     * @param email user的email
     * @param password user的password
     * @return user
     */
    @Select("select * from t_user where email = #{email} and password = #{password}")
    User checkUser(@Param("email") String email, @Param("password") String password);

    /**
     * 用户的注册
     */
    @Insert("insert into t_user values (null, #{username}, #{email}, #{password})")
    int SignUpUser(@Param("username") String username, @Param("email") String email, @Param("password") String password);
}
