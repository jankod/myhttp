package hr.ja.myhttp.model;

import hr.ja.myhttp.db.MemoryEntity;
import hr.ja.myhttp.form.FormSelect;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class User extends MemoryEntity<User> {
    @ToString.Include
    private String name;


    @FormSelect(populate = "chooseBook")
    private List<Book> books = new ArrayList<>();

    public List<Book> chooseBook() {
        return new ArrayList<>();
    }

}
