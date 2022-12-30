package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandom(int min, int max) {
        int diff = max - min;
        Random seed = new Random();
        return seed.nextInt(diff + 1) + min;
    }
}
