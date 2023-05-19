package Learn01;

import Learn01.Classes.Student;
import Learn01.Mappers.Select01;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            Select01 mapper = sqlSession.getMapper(Select01.class);
            Student student = mapper.getAStudentBySid(2);
            System.out.println(student);
        }
        System.out.println(1 << 3);
    }
}
