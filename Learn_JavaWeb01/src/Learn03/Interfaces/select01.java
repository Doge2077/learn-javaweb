package Learn03.Interfaces;

import Learn03.Classes.Student;
import Learn03.Classes.Teacher;

import java.util.List;

public interface select01 {

    Student selectStusid(int Sid);
    List<Student> selectStu();

    Teacher getTeacherByTid(int Sid);

    List<Student> getStudent();

    List<Student> getStudentInfo();

}
