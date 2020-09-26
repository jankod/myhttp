package hr.ja.myhttp.model;

import hr.ja.myhttp.db.Base;
import hr.ja.myhttp.db.MemoryEntity;

public class User extends MemoryEntity<User> {

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        return "user id: " + getId() + "Name: " + name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
