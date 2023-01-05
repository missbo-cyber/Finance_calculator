
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table
    {
            Table()
            {

                    JTable table = new JTable();
                    Object[]columns = {"Data","Bills","Groceries","Entertainment"};
                    DefaultTableModel model = new DefaultTableModel();

                    JFrame frame = new JFrame();
                    frame.getContentPane().setBackground(new Color(0,0,0));
                    frame.getContentPane().setForeground(Color.WHITE);
                    frame.setBounds(100,100,757,610);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.getContentPane().setLayout(null);
                    frame.setLocationRelativeTo(null);
                    Object [] row = new Object[4];

                    model.setColumnIdentifiers(columns);
                    table.setModel(model);

                    table.setBackground(Color.white);
                    table.setBackground(Color.white);
                    table.setSelectionBackground(Color.red);
                    table.setGridColor(Color.red);
                    table.setSelectionBackground(Color.white);
                    table.setFont(new Font("Tahoma",Font.PLAIN,17));
                    table.setRowHeight(30);
                    table.setAutoCreateRowSorter(true);
                    JScrollPane pane = new JScrollPane(table);
                    pane.setForeground(Color.red);
                    pane.setBackground(Color.white);
                    pane.setBounds(10,10,725,354);
                    frame.getContentPane().add(pane);

                    JTextField Data= new JTextField();
                    Data.setBounds(121,374,184,35);
                    frame.getContentPane().add(Data);
                    Data.setColumns(10);

                    JTextField Bills= new JTextField();
                    Bills.setBounds(121,418,184,35);
                    frame.getContentPane().add(Bills);
                    Bills.setColumns(10);

                    JTextField Groceries= new JTextField();
                    Groceries.setBounds(520,374,184,35);
                    frame.getContentPane().add(Groceries);
                    Groceries.setColumns(10);

                    JTextField Entertainment= new JTextField();
                    Entertainment.setBounds(520,418,184,35);
                    frame.getContentPane().add(Entertainment);
                    Entertainment.setColumns(10);


                    JLabel lblData = new JLabel("Data");
                    lblData.setFont(new Font("Tahoma",Font.PLAIN,19));
                    lblData.setBounds(10,374,103,20);
                    lblData.setForeground(Color.white);
                    frame.getContentPane().add(lblData);

                    JLabel lblBills = new JLabel("Bills");
                    lblBills.setFont(new Font("Tahoma",Font.PLAIN,19));
                    lblBills.setBounds(10,418,103,20);
                    lblBills.setForeground(Color.white);
                    frame.getContentPane().add(lblBills);

                    JLabel lblGroceries = new JLabel("Groceries");
                    lblGroceries.setFont(new Font("Tahoma",Font.PLAIN,19));
                    lblGroceries.setBounds(413,374,103,20);
                    lblGroceries.setForeground(Color.white);
                    frame.getContentPane().add(lblGroceries);

                    JLabel lblEntertainment = new JLabel("Entertainment");
                    lblEntertainment.setFont(new Font("Tahoma",Font.PLAIN,19));
                    lblEntertainment.setBounds(390,418,250,20);
                    lblEntertainment.setForeground(Color.white);
                    frame.getContentPane().add(lblEntertainment);

                    JButton btnAdd= new JButton("ADD");
                    btnAdd.setBounds(10,463,295,35);
                    frame.getContentPane().add(btnAdd);
                    btnAdd.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                    row[0]= Data.getText();
                                    row[1]=Bills.getText();
                                    row[2]=Groceries.getText();
                                    row[3]=Entertainment.getText();

                                    model.addRow(row);
                            }
                    });

                    JButton btnDelete= new JButton("DELETE");
                    btnDelete.setBounds(413,463,295,35);
                    frame.getContentPane().add(btnDelete);
                    btnDelete.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                    int i = table.getSelectedRow();
                                    if(i>=0){
                                            model.removeRow(i);

                                    }
                                    else{
                                            JOptionPane.showMessageDialog(frame, "Delete Error");

                                    }
                            }
                    });



                    frame.revalidate();
                    frame.setVisible(true);






            }



    }

