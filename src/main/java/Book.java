import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Cjl
 * @date 2021/8/31 17:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private long id;
    private String name;
    private String author;

}
