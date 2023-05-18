package Learn03.Interfaces;

import Learn03.Classes.Student;
import Learn03.Classes.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface select02 {
    @Select("SELECT * FROM stu WHERE Sid = #{Sid}")
    Student getAStudent(int Sid);

    @Results({
            @Result(column = "Sid", property = "Sid"),
            @Result(column = "Ssex", property = "Sname"),
            @Result(column = "Sname", property = "Ssex")
    })
    @Select("SELECT * FROM stu WHERE Sid = #{Sid}")
    Student getOnlyStudent(int Sid);

    @Select("SELECT * FROM stu")
    List<Student> getStudentList();


    @Results({
            @Result(column = "Sid", property = "Sid"),
            @Result(column = "Sname", property = "Sname"),
            @Result(column = "Ssex", property = "Ssex"),
            @Result(column = "Sid", property = "teacher", one =
            @One(select = "getOneTeacherBySid")
            )
    })
    @Select("SELECT * FROM stu WHERE Sid = #{Sid}")
    Student getAStudentInfo(int Sid);

    @Results({
            @Result(column = "Sid", property = "Sid"),
            @Result(column = "Sname", property = "Sname"),
            @Result(column = "Ssex", property = "Ssex"),
            @Result(column = "Sid", property = "teacher", one =
            @One(select = "getOneTeacherBySid")
            )
    })
    @Select("SELECT * FROM stu")
    List<Student> getAllStudentOneInfoList();

    @Results({
            @Result(column = "Sid", property = "Sid"),
            @Result(column = "Sname", property = "Sname"),
            @Result(column = "Ssex", property = "Ssex"),
            @Result(column = "Sid", property = "teacherList", many =
            @Many(select = "getTeacherBySid")
            )
    })
    @Select("SELECT * FROM stu WHERE Sid = #{Sid}")
    Student getAllStudentInfo(int Sid);

    @Select("SELECT tea.* FROM tea INNER JOIN ts ON tea.Tid = ts.Tid WHERE Sid = #{Sid}")
    Teacher getTeacherBySid(int Sid);

    @Select("SELECT tea.* FROM tea INNER JOIN tsofo ON tea.Tid = tsofo.Tid WHERE Sid = #{Sid}")
    Teacher getOneTeacherBySid(int Sid);


    @Results({
            @Result(column = "Sid", property = "Sid"),
            @Result(column = "Sname", property = "Sname"),
            @Result(column = "Ssex", property = "Ssex"),
            @Result(column = "Sid", property = "teacherList", many =
            @Many(select = "getTeacherBySid")
            )
    })
    @Select("SELECT * FROM stu")
    List<Student> getAllStudentInfoList();

}
