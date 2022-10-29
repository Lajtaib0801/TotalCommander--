import javax.swing.*;
import java.io.File;

import static java.lang.String.format;

public class FileManagement {
    final String defPath = (OsType().toLowerCase().contains("windows") ? "C:\\" : format("/home/%s",System.getProperty("user.name")));

    public DefaultListModel Filelist() {
        DefaultListModel listmodel = new DefaultListModel();
        File folder = new File(defPath);
        if (folder.exists()) {
            for (int i = 0; i < folder.listFiles().length; i++) {
                listmodel.add(i, folder.listFiles()[i]);
            }
        } else {
            listmodel.add(0, format("This file: '%s' does not exist!", defPath));
        }
        return listmodel;
    }

    public String OsType() {
        return System.getProperty("os.name");
    }
}
