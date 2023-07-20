package util;

public class StringGenerator {

    public static final String DIVISION = ",";

    public static String[] generateString(String names) {
        return names.split(DIVISION);
    }
}
