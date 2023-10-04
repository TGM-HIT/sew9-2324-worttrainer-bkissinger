package Model;

import Model.Rechtschreibtrainer;

public interface SaveStrategy {
    public void saveObject(Rechtschreibtrainer trainer, String path);

    public Rechtschreibtrainer loadObject(String path);
}
