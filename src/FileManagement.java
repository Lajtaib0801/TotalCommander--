import javax.swing.*;
import java.io.File;

public class FileManagement {
    final String defPath = "C:\\";
    public DefaultListModel Filelist() {
        DefaultListModel listmodel = new DefaultListModel();
        File folder = new File(defPath);
        for (int i = 0; i < folder.listFiles().length; i++) {
            listmodel.add(i,folder.listFiles()[i]);
        }
        return listmodel;
    }
}
