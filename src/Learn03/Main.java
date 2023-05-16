package Learn03;
import Learn03.Classes.MybatisUtil;
import Learn03.Classes.Student;
import Learn03.Interfaces.insert01;
import Learn03.Interfaces.select01;
import org.apache.ibatis.session.SqlSession;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Vtuber vtuber = new Vtuber("Hiiro", "cat", 114);
//        System.out.println(vtuber);

//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream("config/mybatis-config.xml"));
//        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
//            List<Object> selectStu = sqlSession.selectList("selectStu");
//            selectStu.forEach(System.out::println);
//        }

//        // 利用 MybatisUtil 工具类来创建一个唯一的 SqlSessionFactory，用于创建 SqlSession 对象
//        // 可以避免每次需要使用SqlSession对象时都重新创建 SqlSessionFactory，提高了代码的效率和可维护性
//        try (SqlSession session = MybatisUtil.getSession(true)) {
//            List<Student> selectStu =  session.selectList("selectStu");
//            selectStu.forEach(System.out::println);
//        }

//        // 查询多个学生
//        try (SqlSession sqlSession = MybatisUtil.getSession(true)) {
//            select01 select = sqlSession.getMapper(select01.class);
//            List<Student> stus = select.selectStu();
//            stus.forEach(System.out::println);
//        }

        // 查询单个学生
//        try (SqlSession sqlSession = MybatisUtil.getSession(true)) {
//            select01 selectID = sqlSession.getMapper(select01.class);
//            System.out.println(selectID.selectStusid(3));
//        }

//        // insert 一个学生
//        try (SqlSession sqlSession = MybatisUtil.getSession(true)) {
//            insert01 mapper = sqlSession.getMapper(insert01.class);
//            int t = mapper.insertStu(new Student().setSname("王灿").setSsex("男"));
//            System.out.println(t);
//        }

        // insert 多个学生
        try (SqlSession sqlSession = MybatisUtil.getSession(true)) {
            List<Student> studentList = new ArrayList<>();
            studentList.add(new Student().setSname("申明华").setSsex("男"));
            studentList.add(new Student().setSname("刘婕").setSsex("女"));
            insert01 mapper = sqlSession.getMapper(insert01.class);
            studentList.forEach(mapper::insertStu);
        }


    }
}
