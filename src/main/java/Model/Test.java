package Model;

public class Test {
    public static void main(String[] args) {
        Rechtschreibtrainer t = new Rechtschreibtrainer();
        Save save = new Save();
        save.setSaveStrategy(new SaveJSON());

        t.addWort("https://api.ardmediathek.de/image-service/images/urn:ard:image:3dab66faa8140d8b?w=448&ch=9e935de585dfb889", "katze");
        t.addWort("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSu_HOl_hs_PKxLm3Dn08DkLa4DTCidi0e4vxyTviiCIuPsnq9LPyctt2fKd1wCAx2enc&usqp=CAU", "hund");
        t.addWort("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwKpApBsJBLsGVDl0vepIL7MwObYlwxyeIgYsNLPpF_5ZzbbBm0xo6DVO6Q0e13JWKyuA&usqp=CAU", "hase");
        t.addWort("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxQ8GezgT8z3LASLwmUfSdfPvQNE1b4dkQvm1FjsdlcC7Ktoic6Pz9m2XQ7oYqNt1Hhrg&usqp=CAU", "vogel");

        t.getRandomWort();
        save.saveObject(t, "");

        Rechtschreibtrainer t2 = save.loadObject("");

        System.out.println(t.getAusgewaehlt().getWort() + "\n" + t2.getAusgewaehlt().getWort());

        /*
        boolean wf = false;
        int index = -1;
        String input = JOptionPane.showInputDialog(null, "Random oder index?");
        if (input.equals("random")) {
            input = JOptionPane.showInputDialog(null, "Welches Wort wird dargestellt? \n" + t.getRandomWort());
            wf = t.checkAnswer(input);
            if (wf) {
                JOptionPane.showMessageDialog(null, "Glückwunsch");
                return trainer;
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
