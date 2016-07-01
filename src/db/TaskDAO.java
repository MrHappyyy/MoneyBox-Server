package db;

import java.sql.Connection;
import java.util.List;

public class TaskDAO implements DAO2<TaskEntity> {

    public TaskDAO(Connection connection) {

    }

    public boolean createTable(String nameTable) {
        return false;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public boolean add(TaskEntity taskEntity) {
        return false;
    }

    @Override
    public TaskEntity getById(int id) {
        return null;
    }

    @Override
    public TaskEntity getByName(String name) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(int id, TaskEntity taskEntity) {
        return false;
    }
}
