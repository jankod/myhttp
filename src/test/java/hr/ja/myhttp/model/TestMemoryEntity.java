package hr.ja.myhttp.model;

import hr.ja.myhttp.db.MemoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

@Slf4j
public class TestMemoryEntity {

    public void test1() {
        MemoryRepo repo = new MemoryRepo("/tmp/mydb.txt", User.class, Book.class);

        repo.load();

        List<User> users = User.all();
        log.debug("Found {} users", users);
        //Assertions.assertNotNull(u.getId());

        List<Book> books = Book.all();
        log.debug("Found {} books.", books);

        User u1 = new User();
        u1.setName(RandomStringUtils.randomAlphabetic(7));
        u1.setId(RandomUtils.nextLong(2, 2323));

        Book b1 = new Book();
        b1.setName("tkivo svemira");
        b1.setAuthor(u1);
        u1.getBooks().add(b1);

        repo.save();
    }

    public static void main(String[] args) {
        TestMemoryEntity t = new TestMemoryEntity();
        t.test1();
    }
}
