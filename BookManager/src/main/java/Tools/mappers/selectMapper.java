package Tools.mappers;

import Tools.manage.Book;
import Tools.manage.Borrow;
import Tools.manage.Student;
import Tools.manage.StudentInfo;
import org.apache.ibatis.annotations.*;

import java.util.LinkedList;

public interface selectMapper {

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
    @Results({
            @Result(column = "sid", property = "sid"),
            @Result(column = "sname", property = "sname"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "books", property = "books",
                    many = @Many(select = "selectBookByBid")
            )
    })
    @Select("SELECT * FROM borrow WHERE sid = #{sid}")
    LinkedList<StudentInfo> selectStudentInfoBySid(Integer sid);

}
