package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DELIMITER = "[,:]";
    public static final int ZERO = 0;
    public static final String REGEX = "//(.)\n(.*)";
    public static final int GROUP_ONE = 1;
    public static final int GROUP_TWO = 2;

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }

        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile(REGEX).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(GROUP_ONE);
            return matcher.group(GROUP_TWO).split(customDelimiter);
        }
        return text.split(DELIMITER);
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private static int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < ZERO) {
            throw new RuntimeException();
        }
        return number;
    }

    private static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}
