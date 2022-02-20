package sql.demo.repository;

import java.sql.SQLException;

public class TraidersRepository extends BaseTable implements TableOperations {
    public TraidersRepository() throws SQLException {
        super("traiders");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS traiders(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "sfreqTick INTEGER NOT NULL, " +
                "cash DECIMAL(15,2) NOT NULL DEFAULT 1000, " +
                "traidingMethod INTEGER NOT NULL, " +
                "changeProbability INTEGER NOT NULL DEFAULT 50, " +
                "about VARCHAR(255) NOT NULL)", "Создана таблица " + getTableName());
/*
        super.executeSqlStatement("ALTER TABLE traiders ADD CONSTRAINT check_traiders_traidingMethod " +
                "CHECK(traidingMethod IN (1, 2, 3))",
                "Добавлен CONSTRAINT check_traiders_traidingMethod к "+getTableName());
        super.executeSqlStatement("ALTER TABLE traiders ADD CONSTRAINT check_traiders_changeProbability " +
                "CHECK(changeProbability<=100 AND changeProbability>0)",
                "Добавлен CONSTRAINT check_traiders_changeProbability к "+getTableName());
*/
/*
        super(id);
        this.name = name;
    private int sfreqTick;          // частота совершения сделок
    private BigDecimal cash;        // сумма денег, кроме акций
    private int traidingMethod;     // используемый алгоритм. Зададим его константой
    private int changeProbability;  // Вероятность выполнения операций в %
    private String about;           // дополнительная информация

*/
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }

    @Override
    public void createExtraConstraints() throws SQLException { // создание дополнительных правил
        super.executeSqlStatement("ALTER TABLE traiders ADD CONSTRAINT check_traiders_traidingMethod " +
                "CHECK(traidingMethod IN (1, 2, 3))","Добавлен CONSTRAINT check_traiders_traidingMethod к "+getTableName());
        super.executeSqlStatement("ALTER TABLE traiders ADD CONSTRAINT check_traiders_changeProbability " +
                "CHECK(changeProbability<=100 AND changeProbability>0)","Добавлен CONSTRAINT check_traiders_changeProbability к "+getTableName());
    }

}
