package com.wsd.ecom.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class RandomUtils {

    public static final String ALPHA_NUMERIC_SET = "LlEip0CTVZktFvHjbRScqIngUfMhXodKNQYs246awDWxyeOJG7rP15A39Bz8um";

    private static final SecureRandom rng = new SecureRandom();

    public static int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static String generateRandom(int length) {
        return generateRandom(length, ALPHA_NUMERIC_SET);
    }

    public static String generateRandom(int length, String characterSet) {
        if(length <= 0) {
            return "";
        } else {
            int characterSetLength = characterSet.length();
            StringBuffer randomString = new StringBuffer(length);

            for(int i = 0; i < length; ++i) {
                int index = Math.abs(rng.nextInt()) % characterSetLength;
                randomString.append(characterSet.charAt(index));
            }

            return randomString.toString();
        }
    }


    public static String generateUserLogin() {
        return generateRandom(10);
    }
    public static String generateUserName() {
        return generateRandom(10);
    }
    public static String generateUserEmail() {
        return generateRandom(5) + "@" + generateRandom(5) + ".com";
    }

    public static String generateUserPassword() {
        return generateRandom(10);
    }

    public static String generateItemName() {
        return generateRandom(10);
    }
}
