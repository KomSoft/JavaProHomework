package sql.demo.repository;

import java.sql.SQLException;

public class TraiderShareActionsRepository extends BaseTable implements TableOperations {
    public TraiderShareActionsRepository() throws SQLException {
        super("traider_share_actions");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS traider_share_actions(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "operation INTEGER NOT NULL, " +
                "traider_id BIGINT NOT NULL, " +
                "share_rate_id BIGINT NOT NULL, " +
                "amount BIGINT NOT NULL)", "Создана таблица " + getTableName());
/*
        private int operation;          // тип сделки (покупка/продажа)
        private Traider traider_id;     // ссылка на трейдера
        private ShareRate share_rate_id; // ссылка на курс акции (акцию, ее курс и время выставления)
        private Long amount;            // количество акций, учавствующих в операции
*/
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE traider_share_actions ADD FOREIGN KEY " +
                "(traider_id) REFERENCES traiders(id)",
                "Создан внутренний ключ traider_share_actions.traider_id -> traiders.id");
        super.executeSqlStatement("ALTER TABLE traider_share_actions ADD FOREIGN KEY " +
                "(share_rate_id) REFERENCES share_rates(id)", "Создан внутренний ключ traider_share_actions.share_rate_id -> share_rates.id");

    }

    @Override
    public void createExtraConstraints() throws SQLException {

    }
}
