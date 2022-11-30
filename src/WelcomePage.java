import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage implements ActionListener {
    JFrame frame = new JFrame();
    JButton createtablesbutton = new JButton("Create table");
    JButton showchartbutton= new JButton("Show charts");
    JButton definegoalsbutton = new JButton("Define goals");

    JLabel welcomelabel = new JLabel("Hello");
    WelcomePage(String userID){
        welcomelabel.setBounds(0,0,200,35);
        welcomelabel.setFont(new Font(null, Font.PLAIN,25));
        welcomelabel.setText("Hello "+ userID);
        createtablesbutton.setBounds(115,100,200,25);
        showchartbutton.setBounds(115,200,200,25);
        definegoalsbutton.setBounds(115,300,200,25);
        createtablesbutton.addActionListener(this);
        showchartbutton.addActionListener(this);
        definegoalsbutton.addActionListener(this);
        frame.add(welcomelabel);
        frame.add(createtablesbutton);
        frame.add(showchartbutton);
        frame.add(definegoalsbutton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
