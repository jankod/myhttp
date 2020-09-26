package hr.ja.myhttp.db;

import java.io.Serializable;

public interface MemoryEntity extends Serializable {

    Long getId();
    void setId(Long id);
}
