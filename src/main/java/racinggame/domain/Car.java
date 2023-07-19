package racinggame.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    private final Name name;
    private static final int FORWARD_NUM = 4;

    private static final int MAX_BOUND = 10;

    private Position position;


    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(int randomNo) {
        if (randomNo >= FORWARD_NUM)
            position = position.move();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public Name getName() {
        return name;
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }

    public Position checkMaxPosition(Position maxPosition) {
        if (position.moreThan(maxPosition)) {
            return position;
        }
        return maxPosition;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
