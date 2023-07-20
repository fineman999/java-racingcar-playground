package mock;

import domain.port.RandomGenerator;

public class FakeRandomGenerator implements RandomGenerator {
    private final int number;

    public FakeRandomGenerator(int number) {
        this.number = number;
    }

    @Override
    public int getRandomNumber() {
        return number;
    }
}
