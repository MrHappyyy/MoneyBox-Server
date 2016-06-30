package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClientDAO implements DAO {
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String PASSWORD_COLUMN = "password";
    private static final String TABLE_NAME = "clients";
    private static final String CREATE_TABLE = "create table if not exists " + TABLE_NAME +
            " ('" + ID_COLUMN + "' integer primary key autoincrement, '" + NAME_COLUMN + "' text, '" +
            PASSWORD_COLUMN + "' text);";
    private Connection connection;

    public ClientDAO(Connection connection) {
        this.connection = connection;
        createTable();
    }

    private boolean createTable() {
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE_TABLE);
            int res = statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Не удалось создать таблицу " + TABLE_NAME);
            return false;
        }
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
