package ContactApplication;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Surid on 8/30/2016.
 */
public class JTableDisplay extends JFrame implements ActionListener{

    private FileReader fr;
    private BufferedReader br;

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;


    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    public JTableDisplay() throws IOException{

        initComponents();
        showData();
    }

   private void initComponents() {
       jScrollPane1 = new javax.swing.JScrollPane();
       jTable1 = new javax.swing.JTable();
       jButton1 = new javax.swing.JButton();
       jButton2 = new javax.swing.JButton();

       jButton1.addActionListener(this);
       jButton2.addActionListener(this);

       setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

       jTable1.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {

               },
               new String [] {
                       "Name", "Mobile Number", "Telephone Number", "Fax Number", "Email"
               }
       ) {
           Class[] types = new Class [] {
                   java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
           };

           public Class getColumnClass(int columnIndex) {
               return types [columnIndex];
           }
       });
       jScrollPane1.setViewportView(jTable1);

       jButton1.setText("Edit");

       jButton2.setText("Delete");

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGroup(layout.createSequentialGroup()
                               .addContainerGap()
                               .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                               .addContainerGap())
                       .addGroup(layout.createSequentialGroup()
                               .addGap(124, 124, 124)
                               .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addGap(155, 155, 155)
                               .addComponent(jButton2)
                               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                               .addGap(32, 32, 32)
                               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                       .addComponent(jButton1)
                                       .addComponent(jButton2))
                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addContainerGap())
       );

       pack();

    }

    public void showData() throws FileNotFoundException, IOException {
        System.out.println(getName());
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        fr = new FileReader("ContactsData.txt");
        br = new BufferedReader(fr);
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
            String[] parts = str.split(",");//creating a string array
            Object[] row = {parts[0], parts[1], parts[2], parts[3], parts[4]};

            model.addRow(row);
            System.out.println("Added!");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow >= 0) {
                for(int i = 0; i < 5 ; i++)
                {
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to change "+(String)jTable1.getValueAt(selectedRow,i), "Warning", dialogButton);

                    if(dialogResult == JOptionPane.YES_OPTION) {
                        String value = JOptionPane.showInputDialog(null,"Enter new value");
                        jTable1.setValueAt(value,selectedRow,i);
                    }
                }
                JOptionPane.showMessageDialog(null,"Change Done!");
            }
        }
        if(e.getSource() == jButton2)
        {
            DefaultTableModel model2 = (DefaultTableModel) jTable1.getModel();
            int selectedRow = jTable1.getSelectedRow();
            if(selectedRow >= 0)
            {
                model2.removeRow(selectedRow);
            }
        }
    }
}