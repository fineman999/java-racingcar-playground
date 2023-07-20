package util;

import domain.port.RandomGenerator;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator {

    public static final int BOUND = 10;

    @Override
    public int getRandomNumber() {
        return new Random().nextInt(BOUND);
    }
}
