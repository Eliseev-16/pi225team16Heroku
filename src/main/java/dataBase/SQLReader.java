package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;


public class SQLReader {


    public static int readUser(Long chatId) throws Exception {
        int access = 0;
        try {
            SQLConnection conn = new SQLConnection();
            Statement st = conn.getStatement();
            ResultSet res = st.executeQuery("SELECT * FROM users WHERE chatId='" +chatId +"'LIMIT 1;");

            while (res.next()) {
                if (!res.wasNull()) {
                    if (res.getLong("chatId") == chatId) {
                        access = 1;
                    } else access = 0;
                } else access = 0;
            }
            conn.closeConnection(res);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return access;
    }



}
