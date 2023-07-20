package domain;

import util.StringGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(String names) {
        String[] newNames = StringGenerator.generateString(names);
        List<Car> newCars = Arrays.stream(newNames)
                .map(Car::create)
                .toList();

        return new Cars(newCars);
    }

    public static Cars createWithPosition(String names, int position) {
        String[] newNames = StringGenerator.generateString(names);
        List<Car> newCars = Arrays.stream(newNames)
                .map(name -> Car.createWithPosition(name, position))
                .toList();
        return new Cars(newCars);
    }

    public int size() {
        return cars.size();
    }

    public void moves(int randomNumber) {
        cars.forEach(car -> car.move(randomNumber));
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
