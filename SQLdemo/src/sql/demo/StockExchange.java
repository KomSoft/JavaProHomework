package sql.demo;

import sql.demo.repository.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class StockExchange {
    private TraidersRepository traiders;
    private ShareRatesRepository shareRates;
    private SharesRepository shares;
    private TraiderShareActionsRepository traiderShareActions;
    //  Перечисляемый тип для использования различных database
    //  выбрать нужную базу переменной databaseMode
    public enum databaseModes {H2, MYSQL};
    //          >>>>> Please set Database h2 or MySQL !!! <<<<<
//    public static final databaseModes databaseMode = databaseModes.MYSQL;
    public static final databaseModes databaseMode = databaseModes.H2;
    public static String mySQLPassword = "";
    // уберем final, чтобы менять под разные СУБД
    public static String DB_URL = "jdbc:h2:.\\db\\stockExchange";        // relative path to database
    public static String DB_DRIVER = "org.h2.Driver";

    {
//        Инициалазация переменных для смены СУБД
        switch (databaseMode) {
            case MYSQL: {
                DB_URL = "jdbc:mysql://localhost:3306/stockExchange";
                DB_DRIVER = "com.mysql.cj.jdbc.Driver";
            }
            default: {      //  h2 database
                // do nothing because already set and use relative path
                //  change path to database for Desktop or Laptop
/*
                Map<String, String> map = System.getenv();
                if(map.get("COMPUTERNAME").equalsIgnoreCase("DESKTOP-HOME")) {
                    DB_URL = "jdbc:h2:\\javaproj\\SQLdemo\\db\\stockExchange";              // for my Desktop
                    System.out.println("Database path has changed for Desktop!");
                }
*/
            }
        }
    }

    public StockExchange() throws ClassNotFoundException, SQLException {
        Class.forName(DB_DRIVER);       // проверить драйвер СУБД
        shares = new SharesRepository();
        shareRates = new ShareRatesRepository();
        traiders = new TraidersRepository();
        traiderShareActions = new TraiderShareActionsRepository();
    }

    public static void main(String[] args) {
        try {
            StockExchange stockExchange = new StockExchange();
            stockExchange.createTables();       // в createTable будет getConnection()
            stockExchange.createForeignKeys();
//            stockExchange.createTablesAndForeignKeys();
//            stockExchange.traiders.createExtraConstraints();
/*
            Connection connection = DriverManager.getConnection(DB_URL); // соединение с БД
            System.out.println("Соединение с СУБД выполнено!");
            connection.close();     // отключение от БД
            System.out.println("Отключение от СУБД выполнено.");
*/
            // дописал я для закрытия. Вместе с catch (IOException e)
            stockExchange.shares.close();
            stockExchange.shareRates.close();
            stockExchange.traiders.close();
            stockExchange.traiderShareActions.close();
        } catch (ClassNotFoundException e ) {
            e.printStackTrace();
            System.out.println("JDBC driver для СУБД не найден");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Ошибка SQL");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException while closing databases!");
        }

    }

    public static Connection getConnection() throws SQLException {
        // создать соединение с СУБД
        System.out.println("Получаем соединение с СУБД (" + DB_DRIVER + ")...");
        switch (databaseMode) {
            case MYSQL: {
                if(mySQLPassword.isEmpty()) {       // получить пароль в первый раз
                    System.out.print("To connect MySQL as ROOT please enter password: ");
                    Scanner scanner = new Scanner(System.in);
                    mySQLPassword = scanner.nextLine();
                }
                return DriverManager.getConnection(DB_URL, "root", mySQLPassword);
            }
            default: {      //  h2 database
                return DriverManager.getConnection(DB_URL);      // соединение с БД
            }
        }
    }

    private void createTables() throws SQLException {
        shares.createTable();
        shareRates.createTable();
        traiders.createTable();
        traiderShareActions.createTable();
    }

    private void createForeignKeys() throws SQLException {
        shares.createForeignKeys();
        traiderShareActions.createForeignKeys();
    }
}
