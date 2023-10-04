package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Rechtschreibtrainer
 * @author Benjamin Kissinger
 * @version 2023-10-04
 */
public class Rechtschreibtrainer {
    private List<Wortpaar> woerter;
    private Wortpaar ausgewaehlt;
    private int richtig, falsch;

    public Rechtschreibtrainer() {
        this.woerter = new ArrayList<>();
    }

    public Rechtschreibtrainer(List<Wortpaar> woerter, Wortpaar ausgewaehlt) {
        this.woerter = woerter;
        this.ausgewaehlt = ausgewaehlt;
        this.richtig = 0;
        this.falsch = 0;
    }



    public void addWort(String url, String wort) {
        Wortpaar wortpaar = new Wortpaar(url, wort);
        this.woerter.add(wortpaar);
    }

    public String getRandomWort() {
        Random random = new Random();
        int index = random.nextInt(this.woerter.size());
        int i = 0;
        for (Wortpaar w : this.woerter) {
            if (i == index) {
                //return w;
                this.ausgewaehlt = w;
                return this.ausgewaehlt.getUrl();
            }
            i++;
        }
        return null;
    }

    public String getWortIndex(int index) {
        Random random = new Random();
        int i = 0;

        for (Wortpaar w : this.woerter) {
            if (i == index) {
                this.ausgewaehlt = w;
                return this.ausgewaehlt.getUrl();
            }
            i++;
        }
        return null;
    }

    public boolean checkAnswer(String answer) {
        if (answer.equals(this.ausgewaehlt.getWort())) {
            this.ausgewaehlt = null;
            return true;
        }
        else return false;
    }

    public int getRichtig() {
        return richtig;
    }

    public void setRichtig() {
        this.richtig++;
    }

    public int getFalsch() {
        return falsch;
    }

    public void setFalsch() {
        this.falsch++;
    }

    public List<Wortpaar> getWoerter() {
        return this.woerter;
    }

    public Wortpaar getAusgewaehlt() {
        return this.ausgewaehlt;
    }
}
