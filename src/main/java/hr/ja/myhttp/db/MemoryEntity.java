package hr.ja.myhttp.db;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class MemoryEntity<T extends MemoryEntity<T>> implements Serializable {

    private static final HashMap<Long, MemoryEntity<?>> map = new HashMap<>();

    private Long id;


    public MemoryEntity() {
        save();
    }

    public static <T extends MemoryEntity> List<T> all() {
        return new ArrayList<T>((Collection<? extends T>) map.values());
    }

    protected void save() {
        this.setId(nextId());
        map.put(this.getId(), (T) this);
        //log.debug("Save {}", map);
    }

    protected long nextId() {
        return map.size();
    }

    public static <T extends MemoryEntity> T get(Long id) {
        return (T) map.get(id);
    }

    public void deleteThis() {
        map.remove(this.getId());
        this.setId(null);
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

    @Override
    public String toString() {
        return "id=" + id;
    }
}
