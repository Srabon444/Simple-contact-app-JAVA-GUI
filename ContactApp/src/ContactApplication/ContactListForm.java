package ContactApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Surid on 8/29/2016.
 */
public class ContactListForm extends JFrame implements ActionListener{

    JButton calbtn = new JButton("Add to Contacts.");
    JButton calbtn1 = new JButton("Show Contacts");

    private FileWriter fw;
    private BufferedWriter bw;

    JLabel label1 = new JLabel("Name:");
    JLabel label2 = new JLabel("Mobile number:");
    JLabel label3 = new JLabel("Telephone number:");
    JLabel label4 = new JLabel("Fax number:");
    JLabel label5 = new JLabel("Email:");

    JTextField txtField1 = new JTextField("",20);
    JTextField txtField2 = new JTextField("",20);
    JTextField txtField3 = new JTextField("",20);
    JTextField txtField4 = new JTextField("",20);
    JTextField txtField5 = new JTextField("",20);


    public ContactListForm()
    {
        JPanel mainPanel = new JPanel();

        add(mainPanel);
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.ORANGE);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 1;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridy = 1;
        mainPanel.add(label1,c);
        c.gridy++;
        mainPanel.add(txtField1,c);
        c.gridy++;
        mainPanel.add(label2,c);
        c.gridy++;
        mainPanel.add(txtField2,c);
        c.gridy++;
        mainPanel.add(label3,c);
        c.gridy++;
        mainPanel.add(txtField3,c);
        c.gridy++;
        mainPanel.add(label4,c);
        c.gridy++;
        mainPanel.add(txtField4,c);
        c.gridy++;
        mainPanel.add(label5,c);
        c.gridy++;
        mainPanel.add(txtField5,c);

        calbtn.addActionListener(this);
        calbtn1.addActionListener(this);
        mainPanel.add(calbtn,c);
        mainPanel.add(calbtn1,c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == calbtn)
        {
            try {
                fw = new FileWriter("ContactsData.txt",true);
                bw = new BufferedWriter(fw);

                bw.write(txtField1.getText()+","+txtField2.getText()+","+txtField3.getText()+","+txtField4.getText()+","+txtField5.getText()+"\n");
                bw.flush();

                JTableDisplay table = new JTableDisplay();
                table.setSize(700,200);
                table.setVisible(true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if(e.getSource() == calbtn1)
        {
            try {
                JTableDisplay display = new JTableDisplay();
                display.setSize(700,200);
                display.setVisible(true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }
}
