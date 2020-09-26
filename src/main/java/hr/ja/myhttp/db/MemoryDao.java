package hr.ja.myhttp.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemoryDao<T extends MemoryEntity> {

    private final HashMap<Long, T> map = new HashMap<>();

    public void save(T t) {
        map.put(t.getId(), t);
    }

    public T get(Long id) {
        return map.get(id);
    }

    public void delete(Long id) {
        map.remove(id);
    }


    public Collection<T> search(Predicate<? super T> predicate) {
        return map.values().stream().filter(predicate).collect(Collectors.toList());
    }

//    public interface SearchCall {
//        <T extends MemoryEntity> Collection<T> search(HashMap<Long, T> map);
//    }
}

