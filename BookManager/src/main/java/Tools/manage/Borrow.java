package Tools.manage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Borrow {
    Integer id;
    Integer sid;
    Integer bid;

    public Borrow(Integer sid, Integer bid) {
        this.sid = sid;
        this.bid = bid;
    }
}
