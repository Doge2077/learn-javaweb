package Learn03.Classes;


import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

@Data
@ToString
@Accessors(chain = true)
public class Student {
    Integer Sid;
    String Sname;
    String Ssex;
}
