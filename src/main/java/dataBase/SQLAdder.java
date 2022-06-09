package dataBase;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLAdder {

    public static void addUser(Long chatId, String userName, String firstName, String userKey) throws Exception {

        try {
            SQLConnection conn = new SQLConnection();
            Statement st = conn.getStatement();

            st.execute("INSERT INTO `users` (`id`, `chatId`, `userName`, `firstName`, `userKey`) " +
                    "VALUES (NULL, '"+chatId+"','"+userName+"','"+firstName+"','"+userKey+"')");
            conn.closeConnection();
        } catch (SQLException e){
            throw new Exception("Error adding a user");
        }
        catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }




}
