package domain;

import java.util.Objects;

public class Car {

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
        if (randomNumber >= 4) {
            this.position = position.move();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
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

    public Position checkMaxPosition(Position maxPosition) {
        return position.moreThan(maxPosition);
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }
}
