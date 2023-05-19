package Learn01.Mappers;

import Learn01.Classes.Student;
import org.apache.ibatis.annotations.Select;

public interface Select01 {
    @Select("SELECT * FROM stu WHERE Sid = #{Sid}")
    Student getAStudentBySid(Integer Sid);
}
