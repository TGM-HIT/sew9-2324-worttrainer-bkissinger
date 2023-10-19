package Model;

public class Save {

    private SaveStrategy saveStrategy;
    private String path;

    public Save() {
        this.path = "/home/ben10/Dokumente/SEW/WorttrainerReloaded_Kissinger4BHIT/WorttrainerReloaded_Kissinger4BHIT/data/worttrainer.json";
    }

    /**
     * Save-Strategy auswählen
     * @param s Strategie
     */
    public void setSaveStrategy(SaveStrategy s) {
        this.saveStrategy = s;
    }

    /**
     * Speichert ein Objekt
     * @param trainer Zu speichender Trainer
     * @param path Pfad
     */
    public void saveObject(Rechtschreibtrainer trainer, String path) {
        this.saveStrategy.saveObject(trainer, path);
    }

    /**
     * Trainer laden
     * @param path Pfad
     * @return Trainer
     */
    public Rechtschreibtrainer loadObject(String path) {
        return this.saveStrategy.loadObject(path);
    }

}
