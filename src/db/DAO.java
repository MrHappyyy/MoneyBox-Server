package db;

import java.util.List;

public interface DAO<Entity> {

    boolean createTable(String nameTable);
    List<Entity> getAll();
    boolean add();
}
