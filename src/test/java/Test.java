import Model.Rechtschreibtrainer;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test {
    @org.junit.jupiter.api.Test
    public void test1() {
        Rechtschreibtrainer t1 = new Rechtschreibtrainer();
        t1.addWort("https://api.ardmediathek.de/image-service/images/urn:ard:image:3dab66faa8140d8b?w=448&ch=9e935de585dfb889", "katze");
        t1.getRandomWort();

        assertTrue(t1.checkAnswer("katze"));
    }
}
