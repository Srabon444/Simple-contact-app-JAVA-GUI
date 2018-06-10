package ContactApplication;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Surid on 8/29/2016.
 */
public class ContactStartFrame extends JFrame implements ActionListener{
    JButton calbtn = new JButton("Contacts");
    private static String path = "src" + File.separator;
    private static String ftype = ".jpg";
    private JLabel picLabel;

    public ContactStartFrame()
    {
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File( path + "background6" + ftype ));
            picLabel = new JLabel(new ImageIcon(myPicture));
            this.add(picLabel);
            calbtn.setPreferredSize(new Dimension(20,50));
            calbtn.setBounds(140,85,100,50);
            calbtn.addActionListener(this);
            this.add(calbtn);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[])
    {
        ContactStartFrame g = new ContactStartFrame();
        g.setLocation(10, 10);
        g.setSize(400, 300);
        g.setLayout(null);
        g.setTitle("Menu");
        g.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        g.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calbtn)
        {
            ContactListForm contactListForm = new ContactListForm();
            contactListForm.setTitle("Add Contacts");
            contactListForm.setSize(1000,600);
            contactListForm.setVisible(true);
            this.dispose();
        }
    }
}
