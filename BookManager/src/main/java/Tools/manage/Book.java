package Tools.manage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Book {
    Integer bid;
    final String bname;
    final String binfo;
    final Double price;
}
