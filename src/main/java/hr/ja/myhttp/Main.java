package hr.ja.myhttp;

import hr.ja.myhttp.db.UserDao;
import hr.ja.myhttp.model.User;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        var user = new User();
        user.setId((long) 22);


        var userDao = new UserDao();
        userDao.save(user);

        Collection<User> users = userDao.search(user1 -> user1.getId() > 2);


    }
}
