package sql.demo.repository;

import java.sql.SQLException;

// операции с таблицами
public interface TableOperations {

    void createTable() throws SQLException;

    void createForeignKeys() throws SQLException;   // создание связей

    void createExtraConstraints() throws SQLException; // создание дополнительных правил
}
