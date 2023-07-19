package racinggame.domain;

import java.util.Random;

public class Car {
    private final Name name;
    private static final int FORWARD_NUM = 4;

    private static final int MAX_BOUND = 10;
    private int position = 0;

    private Position position2;


    public Car(String name) {
        this.name = new Name(name);
        position2 = new Position();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable())
            this.position++;
    }
    public void move(int randomNo) {
        if (randomNo >= FORWARD_NUM)
            position2 = position2.move();
    }
    public void move() {
        if (getRandomNo() >= FORWARD_NUM)
            this.position++;
    }

    protected int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    public int getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
