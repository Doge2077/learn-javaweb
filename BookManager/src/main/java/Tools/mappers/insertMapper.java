package Tools.mappers;

import Tools.manage.Book;
import Tools.manage.Borrow;
import Tools.manage.Student;
import org.apache.ibatis.annotations.Insert;

public interface insertMapper {
    // 添加一条学生记录
    @Insert("INSERT INTO student(sname, ssex, sgrade) VALUES (#{sname}, #{ssex}, #{sgrade})")
    Integer insertStudent(Student student);

    // 添加一条书籍记录
    @Insert("INSERT INTO book(bname, binfo, price) VALUES (#{bname}, #{binfo}, #{price})")
    Integer insertBook(Book book);

    // 添加一条借阅记录
    @Insert("INSERT INTO borrow(sid, bid) VALUES (#{sid}, #{bid})")
    Integer insertBorrow(Borrow borrow);

}
