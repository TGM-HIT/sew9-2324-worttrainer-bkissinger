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

    public void saveObject(Rechtschreibtrainer trainer, String path) {
        path = "/home/ben10/Dokumente/SEW/WorttrainerReloaded_Kissinger4BHIT/WorttrainerReloaded_Kissinger4BHIT/data/worttrainer.json";
        JSONObject json = new JSONObject();
        JSONArray jsons = new JSONArray(trainer.getWoerter());
        json.put("woerter",jsons);
        json.put("url", trainer.getAusgewaehlt().getUrl());
        json.put("wort", trainer.getAusgewaehlt().getWort());

        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(json.toString());
            System.out.println("JSON wurde erfolgreich in die Datei geschrieben.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Rechtschreibtrainer loadObject(String path) {
        path = "/home/ben10/Dokumente/SEW/WorttrainerReloaded_Kissinger4BHIT/WorttrainerReloaded_Kissinger4BHIT/data/worttrainer.json";

        try {
            String jsonText = new String(Files.readAllBytes(Paths.get(path)));
            JSONObject json = new JSONObject(jsonText);

            JSONArray jsons = json.getJSONArray("woerter");
            String url = json.getString("url");
            String wort = json.getString("wort");

            Wortpaar ausgewaehlt = new Wortpaar(url, wort);

            List<Wortpaar> woerter = new ArrayList<>();
            for (int i = 0 ; i < jsons.length() ; i++) {
                JSONObject obj = jsons.getJSONObject(i);
                woerter.add(Wortpaar.fromJSON(obj));
            }

            Rechtschreibtrainer trainer = new Rechtschreibtrainer(woerter, ausgewaehlt);
            return trainer;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
