package de.maier;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private static final String DELIMITER = "[\n, ]";

    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = "[\n, ]";
        String numbersWithoutDelimiter = numbers;
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("//") + 2;
            delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
            numbersWithoutDelimiter =
                    numbers.substring(numbers.indexOf("\n") + 1);
        }
        return add(numbersWithoutDelimiter, delimiter);
    }

    private static int add(String numbers, String delimiters) {
        String[] splitNumbers = numbers.split(delimiters);
        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                negativeNumbers.add(num);
            }
            if (num > 1000) {
                num = 0;
            }
            sum += num;
        }
        if (!negativeNumbers.isEmpty()) {
            String message = "Negative Werte sind nicht erlaubt ";
            for (int i = 0; i < negativeNumbers.size() - 1; i++) {
                message += negativeNumbers.get(i) + ",";
            }
            message += negativeNumbers.get(negativeNumbers.size() - 1);
            throw new IllegalArgumentException(message);
        }
        return sum;
    }
}
