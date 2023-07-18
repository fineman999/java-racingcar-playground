import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        if (text.contains("-")) {
            throw new RuntimeException();
        }

        if (text.length() == 1) {
            return Integer.parseInt(text);
        }

        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            // 덧셈 구현
            return sum(tokens);
        }

        if (text.contains(",") || text.contains(":") || text.contains(";")) {
            String[] values = text.split("[,;:]");
            return sum(values);
        }
        return Integer.parseInt(text);
    }

    private static int sum(String[] values) {
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }
}
