package hr.ja.myhttp;

import hr.ja.myhttp.model.User;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        var user = new User();

        long id = 222;
        user.setId(id);
        user.setName("pero");

        user.save();

        Collection<User> users = User.search(user1 -> user1.getId() > 2);
        System.out.println(users);

        User us = User.get(id);

        System.out.println(us);


    }
}
