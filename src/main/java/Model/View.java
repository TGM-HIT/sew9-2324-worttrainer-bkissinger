package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class View {

    /**
     * Überprüft, ob ein File vorhanden ist. Falls ja, wird ein geladener Trainer zurückgegeben.
     * @param t Trainer, der zu befüllen ist
     * @return Trainer
     */
    public static Rechtschreibtrainer loadFile(Rechtschreibtrainer t) {
        String path = "/home/ben10/Dokumente/SEW/WorttrainerReloaded_Kissinger4BHIT/WorttrainerReloaded_Kissinger4BHIT/data/worttrainer.json";
        File file = new File(path);
        Save save = new Save();
        save.setSaveStrategy(new SaveJSON());

        if (file.exists()) {
            t= save.loadObject(path);
            return t;
        } else {
            t.addWort("URLKatze", "Katze");
            t.addWort("URLHund", "Hund");
            t.addWort("URLHase", "Hase");
            t.addWort("URLVogel", "Vogel");
            return null;
        }
    }

    /**
     * Methoode zum Anzeigen von Bilder
     * @param urlTmp Url
     * @param t Trainer
     * @return Input von JOPtionPane
     */
    public static String showImg(String urlTmp, Rechtschreibtrainer t) {
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

            input = JOptionPane.showInputDialog(null, panel, "Welches Wort ist das?", JOptionPane.PLAIN_MESSAGE).toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fehler beim Laden des Bildes.", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
        return input;
    }

    /**
     * Statistik anzeigen
     * @param t trainer
     */
    public static void showStatistics(Rechtschreibtrainer t) {
        JOptionPane.showMessageDialog(null, "Statistik: \n Richtig: " + t.getRichtig() + "\n Falsch: " + t.getFalsch());
    }
    public static void main(String[] args) {

        Rechtschreibtrainer t = new Rechtschreibtrainer();
        Save save = new Save();
        save.setSaveStrategy(new SaveJSON());
        String input = "", wort="";
        boolean wf = false;
        int index = -1;
        t=loadFile(t);

        // Überprüfen, ob Sicherung vorhanden ist
        if (t == null) {
            JOptionPane.showMessageDialog(null, "Keine Sicherungen vorhanden!");
        } else {
            JOptionPane.showMessageDialog(null, "Sicherungen vorhanden!");
        }

        // Der Vorgang des Trainers
        do {
            // Random oder Index?
            input = JOptionPane.showInputDialog(null, "Random oder Index");
            if (input.equals("random")) {
                wort = t.getRandomWort();
            } else {
                // Falls Index: Index abfragen
                index = Integer.parseInt(JOptionPane.showInputDialog(null, "Welcher index?"));
                wort = t.getWortIndex(index);
            }

            // Inputfeld anzeigen
            do {
                input = showImg(wort, t);
                wf = t.checkAnswer(input);
                if (!wf) {
                    JOptionPane.showMessageDialog(null, "Leider falsch, versuche es noch einmal!");
                    t.setFalsch();
                } else {
                    JOptionPane.showMessageDialog(null, "Glückwunsch!");
                    t.setRichtig();
                    wf = true;
                }
            }while(!wf);
            // Statistik anzeigen
            showStatistics(t);

            // Noch ein Bild?
            input = JOptionPane.showInputDialog(null, "Noch ein Bild?");

            // Falls nicht speichern und breaken
            if (input.equals("no")) {
                t.getRandomWort();
                save.saveObject(t, "./data/worttrainer.json");
                JOptionPane.showMessageDialog(null, "Aktueller Stand gespeichert!");
                break;
            }
        }while(true);
    }
}
