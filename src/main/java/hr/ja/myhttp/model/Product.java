package hr.ja.myhttp.model;

import hr.ja.myhttp.db.MemoryEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class Product extends MemoryEntity<User> {
    @ToString.Include
    private String name;

}
