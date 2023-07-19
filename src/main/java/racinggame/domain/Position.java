package racinggame.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }
    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차의 위치는 음수가 될 수 없습니다.");
        }
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public Position move() {
        position = position + 1;
        return this;
    }
}
