package sql.demo.repository;

import java.sql.SQLException;

public class ShareRatesRepository extends BaseTable implements TableOperations {
    public ShareRatesRepository() throws SQLException {
        super("share_rates");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS share_rates(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "operDate DATETIME NOT NULL, " +
                "share_id BIGINT NOT NULL, " +
                "rate DECIMAL(8,2))", "Создана таблица " + getTableName());
/*
        private LocalDateTime operDate;
        private Share share_id;
        private BigDecimal rate;
*/
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE share_rates ADD FOREIGN KEY " +
                "(share_id) REFERENCES shares(id)",
                "Создан внутренний ключ share_rates.share_id -> shares.id");

    }

    @Override
    public void createExtraConstraints() throws SQLException {

    }
}
