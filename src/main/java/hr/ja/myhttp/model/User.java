package hr.ja.myhttp.model;

import hr.ja.myhttp.db.MemoryEntity;

public class User implements MemoryEntity {

    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
