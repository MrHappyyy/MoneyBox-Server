package db;

import java.util.List;

public interface DAO1<Entity> {

    boolean createTable(String tableName);
    List<Entity> getAll();
    boolean add(Entity entity);
}
