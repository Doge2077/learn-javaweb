package Learn03.Classes;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    Integer Tid;
    String Tname;
    List<Student> studentList;
}
