package Learn03.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


// lombook 注解在编译期修改语法树生成对应的构造函数和方法
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Vtuber {
    String name;
    String sex;
    Integer age;
}
