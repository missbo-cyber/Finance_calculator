import java.sql.SQLException;

public class Login
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        IDandPasswords idandPasswords = new IDandPasswords();
        LoginPage loginPage = new LoginPage(idandPasswords.getlogininfo());
    }
}
