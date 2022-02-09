package sql.demo.repository;

import sql.demo.StockExchange;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseTable implements Closeable {
    Connection connection;
    String tableName;

    public BaseTable(String tableName) throws SQLException {
        this.tableName = tableName;
        this.connection = StockExchange.getConnection();
    }

    @Override
    public void close() throws IOException { // почему IOException ??? описка ??
        try {
            System.out.println("Закрываем SQL соединение...");
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException throwables) {
            System.out.println("Ошибка закрытия SQL соединения!");
        }
    }

    void executeSqlStatement(String sql, String description) throws SQLException {
        reopenConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();

        if (description != null) {
            System.out.println(description);
        }
    }

    void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, null);
    };

    void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = StockExchange.getConnection();
        }
    }

    public String getTableName() {
        return tableName;
    }

}
