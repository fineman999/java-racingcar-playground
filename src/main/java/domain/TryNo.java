package domain;

import java.util.Objects;

public class TryNo {
    private final int tryNo;

    public TryNo(int tryNo) {
        this.tryNo = tryNo;
    }

    public static TryNo create(int tryNo) {
        return new TryNo(tryNo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryNo tryNo1 = (TryNo) o;
        return tryNo == tryNo1.tryNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryNo);
    }

    @Override
    public String toString() {
        return "TryNo{" +
                "tryNo=" + tryNo +
                '}';
    }
}
