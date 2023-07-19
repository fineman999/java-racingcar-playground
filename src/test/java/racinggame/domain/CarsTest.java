package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    void findWinners() {
        Car pobi = new Car("pobi", 2);
        Car crong = new Car("crong", 2);
        Car honux = new Car("honux", 1);

        Cars cars = new Cars(Arrays.asList(pobi, crong, honux));


        assertThat(cars.findWinners()).containsExactly(pobi, crong);

    }
}