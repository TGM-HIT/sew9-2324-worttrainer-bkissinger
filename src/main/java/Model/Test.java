package Model;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        Rechtschreibtrainer t = new Rechtschreibtrainer();

        t.addWort("URLKatze", "Katze");
        t.addWort("URLHund", "Hund");
        t.addWort("URLHase", "Hase");
        t.addWort("URLVogel", "Vogel");

        t.getRandomWort();
        Save.saveObject(t, "");

        Rechtschreibtrainer t2 = Save.loadObject("");

        System.out.println(t.getAusgewaehlt().getWort() + "\n" + t2.getAusgewaehlt().getWort());

        /*
        boolean wf = false;
        int index = -1;
        String input = JOptionPane.showInputDialog(null, "Random oder index?");
        if (input.equals("random")) {
            input = JOptionPane.showInputDialog(null, "Welches Wort wird dargestellt? \n" + t.getRandomWort());
            wf = t.checkAnswer(input);
            if (wf) {return trainer;
                JOptionPane.showMessageDialog(null, "Glückwunsch");
            } else {
                JOptionPane.showMessageDialog(null, "Leider falsch");
            }
        } else {
            input = JOptionPane.showInputDialog(null, "Welcher Index?");
            index = Integer.parseInt(input);
            t.getWortIndex(index);
        }*/
    }
}
