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

    public static Rechtschreibtrainer loadFile(Rechtschreibtrainer t) {
        String path = "/home/ben10/Dokumente/SEW/WorttrainerReloaded_Kissinger4BHIT/WorttrainerReloaded_Kissinger4BHIT/data/worttrainer.json";
        File file = new File(path);

        if (file.exists()) {
            t=Save.loadObject(path);
            return t;
        } else {
            t.addWort("URLKatze", "Katze");
            t.addWort("URLHund", "Hund");
            t.addWort("URLHase", "Hase");
            t.addWort("URLVogel", "Vogel");
            return null;
        }
    }

    public static String showImg(String urlTmp) {
        String input = "";
        try {
            // Laden Sie das Bild von der URL herunter
            URL url = new URL(urlTmp);
            Image image = ImageIO.read(url);

            // Erstellen Sie ein JLabel, um das Bild anzuzeigen
            JLabel imageLabel = new JLabel(new ImageIcon(image));

            // Erstellen Sie ein benutzerdefiniertes Dialogfenster
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(imageLabel, BorderLayout.CENTER);

            input = JOptionPane.showInputDialog(null, panel, "Bild anzeigen", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fehler beim Laden des Bildes.", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
        return input;
    }
    public static void main(String[] args) {
        Rechtschreibtrainer t = new Rechtschreibtrainer();
        String input = "", wort="";
        boolean wf = false;
        int index = -1;
        t=loadFile(t);
        if (t == null) {
            JOptionPane.showMessageDialog(null, "Keine Sicherungen vorhanden!");
        } else {
            JOptionPane.showMessageDialog(null, "Sicherungen vorhanden!");
        }

        do {
            input = JOptionPane.showInputDialog(null, "Random oder Index");
            if (input.equals("random")) {
                wort = t.getRandomWort();
            } else {
                index = Integer.parseInt(JOptionPane.showInputDialog(null, "Welcher index?"));
                wort = t.getWortIndex(index);
            }
            do {
                input = showImg(wort);
                wf = t.checkAnswer(input);
                if (!wf) {
                    JOptionPane.showMessageDialog(null, "Leider falsch, versuche es noch einmal!");
                } else {
                    JOptionPane.showMessageDialog(null, "Glückwunsch!");
                    wf = true;
                }
            }while(!wf);
            input = JOptionPane.showInputDialog(null, "Noch ein Bild?");
            if (input.equals("no")) {
                t.getRandomWort();
                Save.saveObject(t, "");
                JOptionPane.showMessageDialog(null, "Aktueller Stand gespeichert!");
                break;
            }
        }while(true);




        // String input = showImg("https://api.ardmediathek.de/image-service/images/urn:ard:image:3dab66faa8140d8b?w=448&ch=9e935de585dfb889");


    }
}
