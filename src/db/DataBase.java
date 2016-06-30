package db;

import java.sql.*;

public class DataBase {
    private static final String nameDateBase = "MoneyBox";
    private Connection connection;
    private ClientDAO clientDAO;
    private MoneyDAO moneyDAO;
    private StatisticDAO statisticDAO;
    private TaskDAO taskDAO;

    public DataBase() {
        if (createDB())
            createTables();
    }

    private void createTables() {
        clientDAO = new ClientDAO(connection);
        moneyDAO = new MoneyDAO(connection);
        statisticDAO = new StatisticDAO(connection);
        taskDAO = new TaskDAO(connection);
    }


    private boolean createDB() {
        try {
            connection = null;
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + nameDateBase);
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
}