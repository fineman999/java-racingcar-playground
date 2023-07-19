package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List findWinners() {
        return findWinners(this.cars, getMaxPosition());
    }

    public static List<Car> findWinners(List<Car> cars, Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }
    private List<Car> findWinners(Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            setWinners(maxPosition, winners, car);
        }
        return winners;
    }

    private void setWinners(Position maxPosition, List<Car> winners, Car car) {
        if (car.isWinner(maxPosition)) {
            winners.add(car);
        }
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = car.checkMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
