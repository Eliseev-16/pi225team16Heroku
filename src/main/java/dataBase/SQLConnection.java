package dataBase;

import java.net.URL;
import java.sql.*;


public class SQLConnection {

//    private String login = "root";
//    private String pass = "";//?useSSL=false

    private String login = "rootFromTelegram";
    private String pass = "12345";//?useSSL=false

    private String url = "jdbc:mysql://localhost:3306/telegrambot";

    private Connection connection;
    private Statement statement;
    private boolean isConnect = false;

    public SQLConnection() throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new Exception("Driver creation error");
        }
        connect();
    }


    private void connect() throws Exception {
        try {
            connection = DriverManager.getConnection(url,login,pass);
            statement = connection.createStatement();
            isConnect = true;
        } catch (SQLException e) {
            throw new Exception("DB connection error");
        }
    }

    public Connection getConnection() throws Exception {
        try {
            if (isConnect) return connection;
        } catch (Exception e){
            throw new Exception("First you need to connect to the database");
        }
        return null;
    }

    public Statement getStatement() throws Exception {
        try {
            if (isConnect) return statement;
        } catch (Exception e){
            throw new Exception("First you need to connect to the database");
        }
        return null;
    }


    public void closeConnection() throws Exception {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e){
            throw new Exception("First you need to connect to the database");
        }

    }


    public void closeConnection(ResultSet r) throws Exception {
        try {
            connection.close();
            statement.close();
            r.close();
        } catch (SQLException e){
            throw new Exception("First you need to connect to the database");
        }
    }


//    public static void main(String[] args) {
//
//        try {
//            SQLConnection sql = new SQLConnection();
//            sql.getStatement();
//            Statement st = sql.getStatement();
//
//            ResultSet res = st.executeQuery("SELECT * FROM users WHERE chatId='2'LIMIT 1;");
//            while (res.next()) {
//                System.out.println("lalala");
//                System.out.println(res.wasNull());
//            }
//
//
//        } catch (Exception e){
//            System.out.println(e.toString() + "lallala");
//        }
//
//
//
//
//    }
}
