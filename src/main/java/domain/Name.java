package domain;

import java.util.Objects;

public class Name {
    private final String name;

    private Name(String name) {
        this.name = name;
    }


    public static Name create(String name) {
        checkValid(name);
        return new Name(name);
    }

    private static void checkValid(String name) {
        if (name == null || name.isEmpty() || isOverNumberFive(name)) {
            throw new IllegalArgumentException("자동차 이름은 공백, null, 5자를 초과할 수 없다.");
        }
    }

    private static boolean isOverNumberFive(String name) {
        return name.length() > 5;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
