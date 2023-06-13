package Tools.manage;

import lombok.Data;

import java.util.LinkedList;

@Data

public class StudentInfo  {
    int sid;
    String sname, ssex;
    LinkedList<Book> books;
}
