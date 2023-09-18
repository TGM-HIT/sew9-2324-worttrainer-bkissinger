package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rechtschreibtrainer {
    private List<Wortpaar> woerter;
    private Wortpaar ausgewaehlt;

    public Rechtschreibtrainer() {
        this.woerter = new ArrayList<>();
    }

    public void addWort(String url, String wort) {
        Wortpaar wortpaar = new Wortpaar(url, wort);
        this.woerter.add(wortpaar);
    }

    public void getRandomWort() {
        Random random = new Random();
        int index = random.nextInt(this.woerter.size());
        int i = 0;
        for (Wortpaar w : this.woerter) {
            if (i == index) {
                //return w;
                this.ausgewaehlt = w;
            }
            i++;
        }
        //return null;
    }

    public void getWortIndex(int index) {
        Random random = new Random();
        int i = 0;

        for (Wortpaar w : this.woerter) {
            if (i == index) {
                //return w;
                this.ausgewaehlt = w;
            }
            i++;
        }
        //return null;
    }

    public boolean checkAnswer(String answer) {
        if (answer.equals(this.ausgewaehlt.getWort())) {
            this.ausgewaehlt = null;
            return true;
        }
        else return false;
    }
}
