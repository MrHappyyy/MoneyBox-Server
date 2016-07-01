package db;

import java.sql.Connection;
import java.util.List;

public class MoneyDAO implements DAO1<MoneyEntity> {

    public MoneyDAO(Connection connection) {

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
    public boolean add(MoneyEntity moneyEntity) {
        return false;
    }
}
