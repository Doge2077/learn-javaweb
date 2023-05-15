package Learn03;
import Learn03.Classes.Vtuber;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Vtuber vtuber = new Vtuber("Hiiro", "cat", 114);
//        System.out.println(vtuber);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream("config/mybatis-config.xml"));
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            List<Object> selectStu = sqlSession.selectList("selectStu");
            selectStu.forEach(System.out::println);
        }

    }
}
