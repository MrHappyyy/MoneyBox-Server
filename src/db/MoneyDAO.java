package db;

import java.sql.Connection;
import java.util.List;

public class MoneyDAO implements DAO {

    public MoneyDAO(Connection connection) {

    }

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
