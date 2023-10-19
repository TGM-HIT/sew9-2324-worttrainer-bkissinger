package Model;

import Model.Rechtschreibtrainer;

/**
 * Interface für Strategy Pattern
 */
public interface SaveStrategy {
    public void saveObject(Rechtschreibtrainer trainer, String path);

    public Rechtschreibtrainer loadObject(String path);
}
