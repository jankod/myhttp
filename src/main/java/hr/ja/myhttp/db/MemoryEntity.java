package hr.ja.myhttp.db;

import hr.ja.myhttp.model.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;


//class Base<T extends Base<T>> {}

public class MemoryEntity<T extends MemoryEntity<T>> implements Serializable {

    private static final HashMap<Long, MemoryEntity<?>> map = new HashMap<>();

    private Long id;

    public void save() {
        map.put(this.getId(), (T) this);
    }

    public static <T extends MemoryEntity> T get(Long id) {
        return (T) map.get(id);
    }

    public void deleteThis() {
        map.remove(this.getId());
    }

    public static void delete(Long id) {
        map.remove(id);
    }


    public static <T extends MemoryEntity> Collection<T> search(Predicate<? super T> predicate) {
        Collection<T> values = (Collection<T>) map.values();
        return values.stream().filter(predicate).collect(Collectors.toList());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
