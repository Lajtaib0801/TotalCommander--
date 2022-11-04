import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;

import static java.lang.String.format;

public class FileManagement {
    final String defPath = (OsType().toLowerCase().contains("windows") ? "C:\\" : format("/home/%s",System.getProperty("user.name")));
    public DefaultListModel Filelist(JList list) {
        DefaultListModel listmodel = new DefaultListModel();
        File folder = new File(defPath);
        String currentPath = "";
        if (list.getModel().getSize() == 0) {
            if (folder.exists()) {
                currentPath = defPath;
                for (int i = 0; i < folder.listFiles().length; i++) {
                    listmodel.add(i, folder.listFiles()[i].toString().split("/")[folder.listFiles()[i].toString().split("/").length-1]);
                }
            } else {
            listmodel.add(0, format("This file: '%s' does not exist!", defPath));
            }
        }
        else {
            currentPath = defPath + "/" + list.getSelectedValue();
            list.clearSelection();
            for (int i = 0; i < new File(currentPath).listFiles().length; i++) {
                listmodel.add(i, new File(currentPath).listFiles()[i].toString().split("/")[folder.listFiles()[i].toString().split("/").length-1]);
            }
        }
        return listmodel;
    }
    public String OsType() {
        return System.getProperty("os.name");
    }
    public void enterPressed(KeyEvent e, JList list) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            Filelist(list);
        }
    }

}
