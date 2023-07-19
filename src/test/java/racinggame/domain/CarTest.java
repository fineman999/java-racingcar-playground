package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("이동")
    void move() {
        Car car = new Car("pobi") {
            @Override
            protected int getRandomNo() {
                return 4;
            }
        };
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("정지")
    void stop() {
        Car car = new Car("pobi") {
            @Override
            protected int getRandomNo() {
                return 3;
            }
        };
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
    @Test
    @DisplayName("이동")
    void moveExternal() {
        Car car = new Car("pobi");
        car.move(4);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("정지")
    void stopExternal() {
        Car car = new Car("pobi");
        car.move(3);
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
    @Test
    @DisplayName("이동")
    void moveInterface() {
        Car car = new Car("pobi");
        car.move(new MovingStrategy() {
            @Override
            public boolean movable() {
                return true;
            }
        });
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("정지")
    void stopInterface() {
        Car car = new Car("pobi");
        car.move(() -> false);
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

}