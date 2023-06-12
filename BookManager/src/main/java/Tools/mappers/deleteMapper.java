package Tools.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface deleteMapper {

    // 删除一条学生记录
    @Delete("DELETE FROM student WHERE sid = #{sid}")
    Integer deleteStudnetBySid(Integer sid);

    // 删除一条书籍记录
    @Delete("DELETE FROM book WHERE bid = #{bid}")
    Integer deleteBookByBid(Integer bid);

    // 删除一条借阅记录
    @Delete("DELETE FROM borrow WHERE sid = #{sid} AND bid = #{bid}")
    Integer deleteBorrowBySidAndBid(@Param("sid")Integer sid, @Param("bid") Integer bid);
}
