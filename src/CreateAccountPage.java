import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CreateAccountPage  {
    CreateAccountPage()throws SQLException,ClassNotFoundException {
        JFrame frame = new JFrame("Registration");
        JButton addAccountButton = new JButton("Add account");
        JButton resetButton = new JButton("Reset");
        JTextField userIDField = new JTextField();
        JPasswordField userPasswordField= new JPasswordField();
        JLabel userIDlabel = new JLabel("Create a userID");
        JLabel userPasswordlabel = new JLabel("Create a Password");
        userIDlabel.setBounds(240,337,75,25);
        userPasswordlabel.setBounds(240,387,75,25);
        userIDField.setBounds(315,337,200,25);
        userPasswordField.setBounds(315,387,200,25);
        addAccountButton.setBounds(290,437,100,25);
        addAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                String userID=userIDField.getText();
                String password= String.valueOf(userPasswordField.getPassword());
                Connection connection = null;

                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?serverTimezone=UTC", "root", "password");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                Statement statement = null;
                if (connection != null) {
                    try {
                        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

                String sql= "INSERT INTO users (user_login, user_password) VALUES('"+userID+"' ,'"+password+"' )";

                    try {
                        statement.executeUpdate(sql);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


            }


            });

        resetButton.setBounds(415,437,100,25);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userIDField.setText("");
                userPasswordField.setText("");

            }
        });

        frame.setSize(800,600);
        frame.add(addAccountButton);
        frame.add(resetButton);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(userIDlabel);
        frame.add(userPasswordlabel);




        frame.setLayout(null);
        frame.setVisible(true);

    }


}
