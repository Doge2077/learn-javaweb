package Tools.mappers;

import org.apache.ibatis.annotations.Delete;

public interface deleteMapper {

    // 删除一条学生记录
    @Delete("DELETE FROM student WHERE sid = #{sid}")
    Integer deleteStudnetBySid(Integer sid);

    // 删除一条书籍记录
    @Delete("DELETE FROM book WHERE bid = #{bid}")
    Integer deleteBookByBid(Integer bid);

    // 删除一条借阅记录
    @Delete("DELETE FROM borrow WHERE id = #{id}")
    Integer deleteBorrowById(Integer id);
}
