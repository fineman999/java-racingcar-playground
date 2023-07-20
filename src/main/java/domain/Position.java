package domain;

import java.util.Objects;

public class Position {
    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position startFromZero() {
        return new Position(0);
    }

    public static Position create(int position) {
        return new Position(position);
    }

    public int getPosition() {
        return position;
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

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }

    public Position move() {
        return new Position(position + 1);
    }

    public Position moreThan(Position maxPosition) {
        return position > maxPosition.position ? this : maxPosition;
    }
}
