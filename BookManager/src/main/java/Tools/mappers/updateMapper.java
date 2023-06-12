package Tools.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface updateMapper{

    // 更新学生姓名信息
    @Update("UPDATE student SET sname = #{sname} WHERE sid = #{sid}")
    Integer updateStudentName(@Param("sid") Integer sid, @Param("sname") String sname);

    // 更新学生性别信息
    @Update("UPDATE student SET ssex = #{ssex} WHERE sid = #{sid}")
    Integer updateStudentSex(@Param("sid") Integer sid, @Param("ssex") String ssex);

    // 更新书籍名称信息
    @Update("UPDATE book SET bname = #{bname} WHERE bid = #{bid}")
    Integer updateBookName(@Param("bid") Integer bid, @Param("bname") String bname);


    // 更新书籍价格信息
    @Update("UPDATE book SET price = #{price} WHERE bid = #{bid}")
    Integer updateBookPrice(@Param("bid") Integer bid, @Param("price") Double price);

}
