package Tools.manage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedList;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StudentInfo extends Student{

    LinkedList<Book> books;
    public StudentInfo(Integer sid, String sname, String ssex) {
        super(sid, sname, ssex);
    }
}
