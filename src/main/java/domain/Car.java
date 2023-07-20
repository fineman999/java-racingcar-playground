package domain;

import java.util.Objects;

public class Car {

    public static final int FORWARD_NUM = 4;
    private final Name name;
    private Position position;

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car create(String name) {
        return new Car(Name.create(name), Position.startFromZero());
    }

    public static Car createWithPosition(String pobi, int position) {
        return new Car(Name.create(pobi), Position.create(position));
    }

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_NUM) {
            this.position = position.move();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public Position checkMaxPosition(Position maxPosition) {
        if (position.moreThan(maxPosition)) {
            return position;
        }
        return maxPosition;
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
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

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
