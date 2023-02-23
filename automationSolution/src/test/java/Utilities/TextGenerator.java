package Utilities;

import Pages.TestBase;

import java.util.Random;

public class TextGenerator extends TestBase {
    public static StringBuilder generateText()
    {
        String chars = "abcd0123";
        Random rnd = new Random();
        StringBuilder transactionRef = new StringBuilder();
        for(int i = 0; i < chars.length(); i++) {
            transactionRef.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return transactionRef;
    }
}
