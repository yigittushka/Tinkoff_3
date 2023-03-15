package Lesson2.SnilsValidator;

import org.jetbrains.annotations.NotNull;

public class SnilssCheck {
    private static final long[] indexMass = {9, 8, 7, 6, 5, 4, 3, 2, 1};


    public static boolean isValid(@NotNull CharSequence val) {
        String snils = val.toString()
                          .replaceAll("[\\s\\-]", "");
        String snil = snils.substring(0, 9);
        int s = Integer.parseInt(snils.substring(9, 11));
        return (snils.matches("^\\d{11}$")
                && !snil.matches("\\d*(?=(\\d)\\1{2})\\d*")
                && Integer.parseInt(snil.substring(0, 9)) > 1001998
        ) && checkSum(snil, s);
    }

    private static boolean checkSum(String snil, int s) {
        long sum = 0;
        char[] snich = snil.toCharArray();
        for (int i = 0; i < 9; i++) {
            sum += indexMass[i] * (snich[i] - '0');
        }
        return (sum % 101 % 100) == s;
    }


}
