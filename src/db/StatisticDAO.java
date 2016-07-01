package db;

import java.sql.Connection;
import java.util.List;

public class StatisticDAO implements DAO1<StatisticEntity> {

    public StatisticDAO(Connection connection) {

    }

    public boolean createTable(String nameTable) {
        return false;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public boolean add(StatisticEntity entity) {
        return false;
    }
}
