package sql.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class StockExchangeSQL {

//    public static final String DB_URL = "jdbc:h2:.\\db\\stockExchange";     // for h2
//    public static final String DB_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/stockExchange";
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            Class.forName(DB_DRIVER);       // проверить драйвер СУБД
            Scanner scanner = new Scanner(System.in);
            System.out.print("To connect MySQL as ROOT please enter password: ");
            String pass = scanner.nextLine();
            Connection connection = DriverManager.getConnection(DB_URL, "root", pass); // соединение с БД
/*
    // for mySQL +  настроить логин и пароль?
    String DB_URL = "jdbc:mysql://localhost:3306/your_DB_name;
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection(DB_URL, user, password); // соединение с БД
*/
            System.out.println("Соединение с СУБД выполнено!");
            connection.close();     // отключение от БД
            System.out.println("Отключение от СУБД выполнено.");
        } catch (ClassNotFoundException e ) {
            e.printStackTrace();
            System.out.println("JDBC driver для СУБД не найден");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Ошибка SQL");
        }

    }

}
