package com.example.servlet.entity;

import com.example.servlet.mapper.userMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.function.Consumer;

public class mybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void userManage(Consumer<userMapper> consumer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            userMapper mapper = sqlSession.getMapper(userMapper.class);
            consumer.accept(mapper);
        }
    }

}
