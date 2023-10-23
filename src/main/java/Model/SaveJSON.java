package Model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SaveJSON implements SaveStrategy {

    /**
     * Übernimmt einen Trainer und speichert ihn als JSON an einer fixen Location.
     * @param trainer Trainer
     * @param path //
     */
    public void saveObject(Rechtschreibtrainer trainer, String path) {
        path = "/home/ben10/Dokumente/SEW/WorttrainerReloaded_Kissinger4BHIT/WorttrainerReloaded_Kissinger4BHIT/data/worttrainer.json";
        JSONObject json = new JSONObject();
        JSONArray jsons = new JSONArray(trainer.getWoerter());
        json.put("richtig", trainer.getRichtig());
        json.put("falsch", trainer.getFalsch());
        json.put("woerter",jsons);
        json.put("url", trainer.getAusgewaehlt().getUrl());
        json.put("wort", trainer.getAusgewaehlt().getWort());

        // Schreibprozess
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(json.toString());
            System.out.println("JSON wurde erfolgreich in die Datei geschrieben.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lädt einen Worttrainer aus einem vorhandenen JSON-File
     * @param path Pfad
     * @return Worttrainer
     */
    public Rechtschreibtrainer loadObject(String path) {
        path = "/home/ben10/Dokumente/SEW/WorttrainerReloaded_Kissinger4BHIT/WorttrainerReloaded_Kissinger4BHIT/data/worttrainer.json";

        // Extracting data...
        try {
            String jsonText = new String(Files.readAllBytes(Paths.get(path)));
            JSONObject json = new JSONObject(jsonText);

            JSONArray jsons = json.getJSONArray("woerter");
            String url = json.getString("url");
            String wort = json.getString("wort");
            int richtig = json.getInt("richtig");
            int falsch = json.getInt("falsch");

            Wortpaar ausgewaehlt = new Wortpaar(url, wort);

            List<Wortpaar> woerter = new ArrayList<>();
            for (int i = 0 ; i < jsons.length() ; i++) {
                JSONObject obj = jsons.getJSONObject(i);
                woerter.add(Wortpaar.fromJSON(obj));
            }

            // Neuen Trainer erstellen
            Rechtschreibtrainer trainer = new Rechtschreibtrainer(woerter, ausgewaehlt);
            trainer.setRichtig(richtig);
            trainer.setFalsch(falsch);
            return trainer;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
