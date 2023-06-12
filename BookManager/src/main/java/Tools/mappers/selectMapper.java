package Tools.mappers;

import Tools.manage.Book;
import Tools.manage.Borrow;
import Tools.manage.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedList;

public interface selectMapper {

    // 根据学生编号查找指定学生
    @Select("SELECT * FROM student WHERE sid = #{sid}")
    Student selectStudentBySid(Integer sid);

    // 根据书籍编号查找指定书籍
    @Select("SELECT * FROM book WHERE bid = #{bid}")
    Book selectBookByBid(Integer bid);

    // 根据借阅编号查找指定借阅记录
    @Select("SELECT * FROM borrow WHERE sid = #{sid} AND bid = #{bid}")
    Borrow selectBorrowBySidAndBid(@Param("sid")Integer sid, @Param("bid") Integer bid);

    // 查询所有学生信息
    @Select("SELECT * FROM student")
    LinkedList<Student> selectAllStudents();

    // 查询所有书籍信息
    @Select("SELECT * FROM book")
    LinkedList<Book> selectAllBooks();

    // 查询所有的借阅信息
    @Select("SELECT * FORM borrow")
    LinkedList<Borrow> selectAllBorrows();

}
