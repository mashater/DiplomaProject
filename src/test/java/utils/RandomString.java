package utils;

import java.util.Random;

public class RandomString {
    public static String getRandomString(int count){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        Random random = new Random();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }
}
