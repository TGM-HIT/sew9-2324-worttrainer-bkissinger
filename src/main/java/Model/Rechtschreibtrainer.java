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

    /**
     * Erstellt einen leeren Worttrainer
     */
    public Rechtschreibtrainer() {
        this.woerter = new ArrayList<>();
    }

    /**
     * Erstellt einen Worttrainer
     * @param woerter woerter als liste
     * @param ausgewaehlt ausgewaehltes Wortpaar
     */
    public Rechtschreibtrainer(List<Wortpaar> woerter, Wortpaar ausgewaehlt) {
        this.woerter = woerter;
        this.ausgewaehlt = ausgewaehlt;
        this.richtig = 0;
        this.falsch = 0;
    }


    /**
     * Added ein Wort
     * @param url URL
     * @param wort Wort
     */
    public void addWort(String url, String wort) {
        if (url != null && wort != null) {
            Wortpaar wortpaar = new Wortpaar(url, wort);
            this.woerter.add(wortpaar);
        }
    }

    /**
     * Sucht ein Random Wort raus
     * @return Random wort
     */
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

    /**
     * Sicht ein Wort mit einem Index heraus
     * @param index
     * @return Wort
     */
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

    /**
     * Überprüft die Antwort
     * @param answer Antwort vom User
     * @return true/false für richtig/falsch
     * @throws IllegalArgumentException falls Antwort null ist
     */
    public boolean checkAnswer(String answer) throws IllegalArgumentException{
        if (answer == null) {
            throw new IllegalArgumentException("Answer is null!");
        }
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
    public void setRichtig(int r) {
        this.richtig = r;
    }

    public int getFalsch() {
        return falsch;
    }

    public void setFalsch() {
        this.falsch++;
    }
    public void setFalsch(int f) {
        this.falsch = f;
    }

    public List<Wortpaar> getWoerter() {
        return this.woerter;
    }

    public Wortpaar getAusgewaehlt() {
        return this.ausgewaehlt;
    }
}
