package sql.demo.repository;

import java.sql.SQLException;

public class SharesRepository extends BaseTable implements TableOperations {
    public SharesRepository() throws SQLException {
        super("shares");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS shares(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "startPrice DECIMAL(8,2), " +
                "changeProbability INTEGER NOT NULL, " +
                "delta INTEGER NOT NULL)", "Создана таблица " + getTableName());

    }

    @Override
    public void createForeignKeys() throws SQLException {

    }

    @Override
    public void createExtraConstraints() throws SQLException {

    }
}
