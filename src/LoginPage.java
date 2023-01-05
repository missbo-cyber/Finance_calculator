import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame("Piggy Bank");
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton createaacountButton = new JButton("Create an account");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField= new JPasswordField();
    JLabel userIDlabel = new JLabel("userID:");
    JLabel userPasswordlabel = new JLabel("Password:");
    JLabel displayField = new JLabel();
    JLabel messagelabel = new JLabel();
    ImageIcon image = new ImageIcon(getClass().getResource("piggyapp.gif"));

    HashMap<String,String> logininfo= new HashMap<String,String>();
    LoginPage(HashMap<String,String> loginInfoOriginal){
        logininfo= loginInfoOriginal;// the copy of the HashMap that is globally available to our login page so other methods can use it
        userIDlabel.setBounds(240,337,75,25);
        userPasswordlabel.setBounds(240,387,75,25);
        messagelabel.setBounds(350,487,250,35);
        messagelabel.setFont(new Font("Tahoma", Font.PLAIN,25));
        userIDField.setBounds(315,337,200,25);
        userPasswordField.setBounds(315,387,200,25);
        loginButton.setBounds(290,437,100,25);
        loginButton.addActionListener(this);
        createaacountButton.setBounds(327,480,150,25);
        createaacountButton.addActionListener(this);
        resetButton.setBounds(415,437,100,25);
        resetButton.addActionListener(this);

        displayField = new JLabel(image);
        displayField.setBounds(215,30,375,275);


        frame.add(userIDlabel);
        frame.add(displayField);
        frame.add(userPasswordlabel);
        frame.add(messagelabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(createaacountButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// we can close the frame
        frame.setSize(800,600);// the size of the frame
        frame.setLayout(null);// without layout manager
        frame.setVisible(true);// we can see the frame
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if(e.getSource()==loginButton){
            String userID= userIDField.getText();
            String password= String.valueOf(userPasswordField.getPassword());
            if(logininfo.containsKey(userID)){
                // to verify if the password is correct
                if(logininfo.get(userID).equals(password)){
                    messagelabel.setForeground(Color.green);
                    messagelabel.setText("Login successful");
                    frame.dispose();// it closes the first window
                    WelcomePage welcomePage = new WelcomePage(userID);
                }
                else{
                    messagelabel.setForeground(Color.red);
                    messagelabel.setText("Wrong password");
                }

            }
            else{
                messagelabel.setForeground(Color.red);
                messagelabel.setText("Username not found");
            }
        }
        if(e.getSource()==createaacountButton){
            frame.dispose();
            try {
                CreateAccountPage createaccount = new CreateAccountPage();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }

    }
}
