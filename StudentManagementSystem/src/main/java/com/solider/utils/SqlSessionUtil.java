package com.solider.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * SqlSession工具类
 * @author Solider
 * @version 1.0
 * @since 1.0
 */
public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;

    // 使用ThreadLocal对SqlSession进行管理
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    static {
        try {
            // 解析mybatis核心配置文件，获取SqlSession对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("mybatis-config.xml")
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 提供sqlSession对象
     * @return SqlSession
     */
    public static SqlSession openSession() {
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭sqlSession对象，并将其从ThreadLocal集合中移除
     */
    public static void close() {
        SqlSession sqlSession = local.get();
        if (sqlSession != null) {
            sqlSession.close();
            local.remove();
        }
    }
}
