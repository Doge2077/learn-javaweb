package Learn03.Classes;


import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Data
@ToString
@Accessors(chain = true)
public class Student {
    Integer Sid;
    String Sname;
    String Ssex;
    Teacher teacher;  // 查询 多对一 关系 时添加
//    List<Teacher> teacherList;
}
