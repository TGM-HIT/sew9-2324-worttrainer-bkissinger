package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class View {

    public View() {

    }

    public boolean checkFile(String path) {
        File file = new File(path);

        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static void showImg(String urlTmp) {
        try {
            // Laden Sie das Bild von der URL herunter
            URL url = new URL(urlTmp);
            Image image = ImageIO.read(url);

            // Erstellen Sie ein JLabel, um das Bild anzuzeigen
            JLabel imageLabel = new JLabel(new ImageIcon(image));

            // Erstellen Sie ein benutzerdefiniertes Dialogfenster
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(imageLabel, BorderLayout.CENTER);

            JOptionPane.showInputDialog(null, panel, "Bild anzeigen", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fehler beim Laden des Bildes.", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        showImg("https://api.ardmediathek.de/image-service/images/urn:ard:image:3dab66faa8140d8b?w=448&ch=9e935de585dfb889");
    }
}
