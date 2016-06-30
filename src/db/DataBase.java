package db;

import java.sql.*;

public class DataBase {
    private static final String nameDateBase = "MoneyBox";
    private Connection connection;

    public DataBase() {
        createDB();
    }

    private boolean createDB() {
        try {
            connection = null;
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + nameDateBase + ".db");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Не удалось создать базу данных");
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Не удалось создать базу данных");
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}