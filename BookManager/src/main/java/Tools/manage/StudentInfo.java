package Tools.manage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedList;

@Data

public class StudentInfo  {
    int sid;
    String sname, ssex;
    LinkedList<Book> books;
}
