package db;

import java.util.List;

public interface DAO2<Entity> extends DAO1<Entity> {

    Entity getById(int id);
    Entity getByName(String name);
    boolean delete(int id);
    boolean update(int id, Entity entity);
}
