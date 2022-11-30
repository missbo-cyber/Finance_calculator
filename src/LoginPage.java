import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("login");
    JButton resetButton = new JButton("reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField= new JPasswordField();
    JLabel userIDlabel = new JLabel("userID:");
    JLabel userPasswordlabel = new JLabel("Password:");
    JLabel messagelabel = new JLabel();

    HashMap<String,String> logininfo= new HashMap<String,String>();
    LoginPage(HashMap<String,String> loginInfoOriginal){
        logininfo= loginInfoOriginal;// the copy of the HashMap that is globally available to our login page so other methods can use it
        userIDlabel.setBounds(50,100,75,25);
        userPasswordlabel.setBounds(50,150,75,25);
        messagelabel.setBounds(125,250,250,35);
        messagelabel.setFont(new Font(null, Font.ITALIC,25));
        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);
        loginButton.setBounds(125,200,100,25);
        loginButton.addActionListener(this);
        resetButton.setBounds(225,200,100,25);
        resetButton.addActionListener(this);



        frame.add(userIDlabel);
        frame.add(userPasswordlabel);
        frame.add(messagelabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// we can close the frame
        frame.setSize(420,420);// the size of the frame
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

    }
}
