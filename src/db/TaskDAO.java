package db;

import java.sql.Connection;
import java.util.List;

public class TaskDAO implements DAO {

    public TaskDAO(Connection connection) {

    }

    @Override
    public boolean createTable(String nameTable) {
        return false;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public boolean add() {
        return false;
    }
}
