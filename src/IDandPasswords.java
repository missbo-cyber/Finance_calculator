import java.util.HashMap;
import  java.sql.*;

public class IDandPasswords {
    HashMap <String,String> logininfo = new HashMap<String,String>();

    IDandPasswords () throws SQLException, ClassNotFoundException {




        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?serverTimezone=UTC", "root", "password");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select*from users");
        while (resultSet.next())
        {
            String userLogin = resultSet.getString("user_login");

            if(!logininfo.containsKey(userLogin))
logininfo.put(userLogin,resultSet.getString("user_password"));

        }
    }

     protected HashMap getlogininfo(){
        return logininfo;
    }


}
