package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rechtschreibtrainer {
    private List<Wortpaar> woerter;

    public Rechtschreibtrainer() {
        this.woerter = new ArrayList<>();
    }

    public void addWort(String url, String wort) {
        Wortpaar wortpaar = new Wortpaar(url, wort);
        this.woerter.add(wortpaar);
    }

    public Wortpaar getRandomWort() {
        Random random = new Random();
        int index = random.nextInt(this.woerter.size());
        int i = 0;
        for (Wortpaar w : this.woerter) {
            if (i == index) {
                return w;
            }
            i++;
        }
        return null;
    }

    public Wortpaar getWortIndex(int index) {
        Random random = new Random();
        int i = 0;

        for (Wortpaar w : this.woerter) {
            if (i == index) {
                return w;
            }
            i++;
        }
        return null;
    }
}
