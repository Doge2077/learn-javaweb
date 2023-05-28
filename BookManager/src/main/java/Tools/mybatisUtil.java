package Tools;

import Tools.mappers.*;
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
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("config/mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertManage(Consumer<insertMapper> consumer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            insertMapper mapper = sqlSession.getMapper(insertMapper.class);
            consumer.accept(mapper);
        }
    }

    public static void deleteManage(Consumer<deleteMapper> consumer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            deleteMapper mapper = sqlSession.getMapper(deleteMapper.class);
            consumer.accept(mapper);
        }
    }

    public static void updateManage(Consumer<updateMapper> consumer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            updateMapper mapper = sqlSession.getMapper(updateMapper.class);
            consumer.accept(mapper);
        }
    }

    public static void selectManage(Consumer<selectMapper> consumer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            selectMapper mapper = sqlSession.getMapper(selectMapper.class);
            consumer.accept(mapper);
        }
    }

}
