package hr.ja.myhttp.model;

import hr.ja.myhttp.db.MemoryEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class User extends MemoryEntity<User> {
    private String name;

}
