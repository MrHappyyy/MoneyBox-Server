package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements DAO2<ClientEntity> {
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
        createTable(TABLE_NAME);
    }

    @Override
    public boolean createTable(String tableName) {
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE_TABLE);
            int res = statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            //e.printStackTrace();
            System.err.println("Не удалось создать таблицу " + TABLE_NAME + "...");
            return false;
        }
    }

    @Override
    public List<ClientEntity> getAll() {

        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM " + TABLE_NAME);
            List<ClientEntity> clients = new ArrayList<ClientEntity>();

            while (res.next()) {
                clients.add(new ClientEntity(res.getInt(ID_COLUMN), res.getString(NAME_COLUMN),
                        res.getString(PASSWORD_COLUMN)));
            }
            statement.close();
            res.close();
            return clients;
        } catch (SQLException e) {
            //e.printStackTrace();
            System.err.println("Не удалось получить всех клиентов с таблицы..." + TABLE_NAME);
            return null;
        }
    }

    @Override
    public boolean add(ClientEntity entity) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO " + TABLE_NAME + " ("
                    + NAME_COLUMN + ", " + PASSWORD_COLUMN + ") VALUES (?, ?)");
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getPassword());

            int res = statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            //e.printStackTrace();
            System.err.println("Не удалось добавить нового клиента в таблицу...");
            return false;
        }
    }

    @Override
    public ClientEntity getById(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + ID_COLUMN + " = '" + id + "'");
            ClientEntity entity = new ClientEntity(res.getInt(ID_COLUMN), res.getString(NAME_COLUMN),
                    res.getString(PASSWORD_COLUMN));
            statement.close();
            res.close();
            return entity;
        } catch (SQLException e) {
            //e.printStackTrace();
            System.err.println("Не удалось получить клиента по id...");
            return null;
        }
    }

    @Override
    public ClientEntity getByName(String name) {
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + NAME_COLUMN + " = '" + name + "'");
            ClientEntity entity = new ClientEntity(res.getInt(ID_COLUMN), res.getString(NAME_COLUMN),
                    res.getString(PASSWORD_COLUMN));
            statement.close();
            res.close();
            return entity;
        } catch (SQLException e) {
            //e.printStackTrace();
            //System.out.println(e.getMessage());
            System.err.println("Не удалось получить клиента по имени...");
            return null;
        }
    }

    public ClientEntity getByPass(String pass) {
        try {
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + PASSWORD_COLUMN + " = '" + pass + "'");
            ClientEntity entity = new ClientEntity(res.getInt(ID_COLUMN), res.getString(NAME_COLUMN),
                    res.getString(PASSWORD_COLUMN));
            statement.close();
            res.close();
            return entity;
        } catch (SQLException e) {
            //e.printStackTrace();
            //System.out.println(e.getMessage());
            System.err.println("Не удалось получить клиента по паролю...");
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM " + TABLE_NAME + " WHERE " + ID_COLUMN + " = '" + id + "'");
            int res = statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Не удалось удалить c таблицы клиента по id...");
            return false;
        }
    }

    @Override
    public boolean update(int id, ClientEntity entity) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE " + TABLE_NAME + " SET " +
                    NAME_COLUMN + " = '" + entity.getName() + "', " + PASSWORD_COLUMN + " = '" + entity.getPassword() +
                    "' WHERE " + ID_COLUMN + " = '" + id + "'");
            int res = statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException e) {
            //e.printStackTrace();
            System.err.println("Не удалось внести изменения в клиенте по id...");
            return false;
        }
    }
}
