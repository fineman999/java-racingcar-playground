package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {


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

}