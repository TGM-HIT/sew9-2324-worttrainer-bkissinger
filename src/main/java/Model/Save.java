package Model;

public class Save {

    private SaveStrategy saveStrategy;
    private String path;

    public Save() {
        this.path = "/home/ben10/Dokumente/SEW/WorttrainerReloaded_Kissinger4BHIT/WorttrainerReloaded_Kissinger4BHIT/data/worttrainer.json";
    }

    public void setSaveStrategy(SaveStrategy s) {
        this.saveStrategy = s;
    }

    public void saveObject(Rechtschreibtrainer trainer, String path) {
        this.saveStrategy.saveObject(trainer, path);
    }

    public Rechtschreibtrainer loadObject(String path) {
        return this.saveStrategy.loadObject(path);
    }

}
