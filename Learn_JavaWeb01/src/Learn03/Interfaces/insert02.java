package Learn03.Interfaces;

import Learn03.Classes.Student;
import org.apache.ibatis.annotations.Insert;

public interface insert02 {
    @Insert("INSERT INTO stu(Sname, Ssex) VALUE (#{Sname}, #{Ssex})")
    int insertStudent(Student student);
}
