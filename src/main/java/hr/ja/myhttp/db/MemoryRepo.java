package hr.ja.myhttp.db;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Set;


@Slf4j
public class MemoryRepo {


    private String dbPath;
    private Class<? extends MemoryEntity>[] memoryClasses;

    private DB db;

    public MemoryRepo(String dbPath, Class<? extends MemoryEntity>... memoryClasses) {
        this.dbPath = dbPath;
        this.memoryClasses = memoryClasses;
        db = new DB();

        for (Class<? extends MemoryEntity> memoryClass : memoryClasses) {
            extractMap(memoryClass);
        }

    }

    private <T extends MemoryEntity<T>> void extractMap(Class<? extends MemoryEntity> clazz) {
        try {
            Field mapField = clazz.getSuperclass().getDeclaredField("map");
            mapField.setAccessible(true);
            MemoryEntity<T> entity = clazz.getDeclaredConstructor().newInstance();
            HashMap map = (HashMap) mapField.get(entity);
            this.db.classMap.put(clazz, map);
            //    log.debug("got map {}", map);

        } catch (Exception e) {
            log.error("", e);
        }
    }


    public void save() {
        File f = new File(this.dbPath);
        try {

            FileOutputStream out = new FileOutputStream(f);
            Kryo k = new Kryo();
            k.setClassLoader(Thread.currentThread().getContextClassLoader());
            for (Class<? extends MemoryEntity> c : this.memoryClasses) {
                k.register(c);
            }
            Output o = new Output(out);
            for (Class<? extends MemoryEntity> memoryClass : memoryClasses) {
                extractMap(memoryClass);
            }

            k.writeClassAndObject(o, db);
            o.close();
            out.close();
            log.debug("Saved at '{}'", f);

        } catch (Throwable e) {
            log.error("", e);
        }
    }

    @SneakyThrows
    public void load() {
        File f = new File(this.dbPath);
        if (!f.exists()) {
            log.debug("DB not exist yet at location '{}'!", dbPath);
            return;
        }
        FileInputStream in = new FileInputStream(f);
        Kryo k = new Kryo();
        for (Class<? extends MemoryEntity> c : this.memoryClasses) {
            k.register(c);
        }
        k.setClassLoader(Thread.currentThread().getContextClassLoader());
        Input i = new Input(in);
        DB memo = (DB) k.readClassAndObject(i);
        in.close();
        this.db = memo;

        Set<Class<? extends MemoryEntity>> classes = memo.classMap.keySet();
        for (Class<? extends MemoryEntity> c : classes) {
            MemoryEntity memoryEntity = c.getConstructor().newInstance();
            Field mapField = c.getSuperclass().getDeclaredField("map");
            mapField.setAccessible(true);
            HashMap map = (HashMap)   mapField.get(memoryEntity);
            map.putAll(memo.classMap.get(c));
        }
    }

    @Data
    private static class DB implements Serializable {
        private HashMap<Class<? extends MemoryEntity>, HashMap<Long, MemoryEntity>> classMap = new HashMap<>();

    }

}
