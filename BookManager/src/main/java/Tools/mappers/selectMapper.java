package Tools.mappers;

import Tools.manage.*;
import org.apache.ibatis.annotations.*;

import java.util.LinkedList;

public interface selectMapper {

    // 查询全部学生信息
    @Select("SELECT * FROM student")
    LinkedList<Student> selectAllStu();

    // 查询全部书籍信息
    @Select("SELECT * FROM book")
    LinkedList<Book> selectAllBook();

    // 根据学生编号查找指定学生
    @Select("SELECT * FROM student WHERE sid = #{sid}")
    Student selectStudentBySid(Integer sid);

    // 根据书籍编号查找指定书籍
    @Select("SELECT * FROM book WHERE bid = #{bid}")
    Book selectBookByBid(Integer bid);

    // 根据学生学号和书籍编号查找指定借阅记录
    @Select("SELECT * FROM borrow WHERE sid = #{sid} AND bid = #{bid}")
    Borrow selectBorrowBySidAndBid(@Param("sid")Integer sid, @Param("bid") Integer bid);

    // 根据学生学号查询借阅的全部书籍
    @Select("SELECT * FROM book INNER JOIN borrow ON book.bid = borrow.bid WHERE sid = #{sid}")
    LinkedList<Book> getBookBySid(Integer sid);

    // 根据书籍查询借阅的全部学生
    @Select("SELECT * FROM student INNER JOIN borrow ON student.sid = borrow.sid WHERE bid = #{bid}")
    LinkedList<Student> getSutedntByBid(Integer bid);

    // 查询所有信息
    @Results({
            @Result(column = "sid", property = "sid"),
            @Result(column = "sname", property = "sname"),
            @Result(column = "ssex", property = "ssex"),
            @Result(column = "sid", property = "books", many =
            @Many(select = "getBookBySid")
            )
    })
    @Select("SELECT * FROM student")
    LinkedList<StudentInfo> selectAll();

}
