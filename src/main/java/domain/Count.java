package domain;

import java.util.Objects;

public class Count {
    private final int count;

    private Count(int count) {
        this.count = count;
    }

    public static Count start() {
        return new Count(0);
    }

    public static Count create(int count) {
        return new Count(count);
    }

    public Count countUp() {
        return new Count(count + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return "Count{" +
                "count=" + count +
                '}';
    }

    public boolean finish(TryNo tryNo) {
        return TryNo.create(count).equals(tryNo);
    }
}
