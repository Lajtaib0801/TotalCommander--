import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class GUI {

    FileManagement fm = new FileManagement();
    GUI(){
        JList listR = new JList(fm.Filelist());
        JList listL = new JList(fm.Filelist());
        JFrame f = new JFrame();
        f.setTitle("TCMD--");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close app with "X" and not hide
        f.setSize(700,700);
        f.setLocationRelativeTo(null); //center new window
        f.setVisible(true);
        f.setLayout(new GridLayout(1,2,10,0));
        f.add(listL);
        f.add(listR);
    }

}
