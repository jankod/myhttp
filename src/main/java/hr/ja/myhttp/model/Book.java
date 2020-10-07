package hr.ja.myhttp.model;

import hr.ja.myhttp.db.MemoryEntity;
import lombok.*;

@Getter @Setter
@ToString(callSuper = true)
public class Book extends MemoryEntity<Book> {
    private String name;

    private User author;

}
