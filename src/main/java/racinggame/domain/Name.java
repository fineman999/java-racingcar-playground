package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;
    private static final String ERROR_MESSAGE = "이름은 5자 이하만 가능합니다.";

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name.trim();
    }

    private void validate(String name) {
        if (StringUtils.isBlack(name)) {
            throw new IllegalArgumentException("자동차 이름은 null이거나 빈 공백이 될 수 없습니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
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
