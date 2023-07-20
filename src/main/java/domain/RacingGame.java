package domain;

import java.util.Objects;

public class RacingGame {

    private final Cars cars;
    private final TryNo tryNo;

    private Count count;

    private RacingGame(Cars cars, TryNo tryNo) {
        this.cars = cars;
        this.tryNo = tryNo;
        this.count = Count.start();
    }

    public RacingGame(Cars newCars, TryNo newTryNo, Count newCount) {
        this.cars = newCars;
        this.tryNo = newTryNo;
        this.count = newCount;
    }

    public static RacingGame create(String names, int tryNo) {
        Cars newCars = Cars.create(names);
        TryNo newTryNo = TryNo.create(tryNo);
        return new RacingGame(newCars, newTryNo);
    }

    public static RacingGame createWithPosition(String names, int tryNo, int position) {
        Cars newCars = Cars.createWithPosition(names, position);
        TryNo newTryNo = TryNo.create(tryNo);
        Count newCount = Count.create(position);
        return new RacingGame(newCars, newTryNo, newCount);
    }
    public void race(int randomNumber) {
        cars.moves(randomNumber);
        this.count = count.countUp();
    }

    public boolean isEnd() {
        return count.finish(tryNo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(cars, that.cars) && Objects.equals(tryNo, that.tryNo) && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, tryNo, count);
    }

    @Override
    public String toString() {
        return "RacingGame{" +
                "cars=" + cars +
                ", tryNo=" + tryNo +
                ", count=" + count +
                '}';
    }
}
