package domain;

import domain.port.RandomGenerator;
import mock.FakeRandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 생성 테스트")
    void create() {
        Car car = Car.create("pobi");
        assertThat(car).isEqualTo(Car.create("pobi"));
    }

    @ParameterizedTest
    @CsvSource({"4","9"})
    @DisplayName("자동차 이동 테스트")
    void move(int randomNumber) {
        RandomGenerator randomGenerator = new FakeRandomGenerator(randomNumber);
        Car car = Car.create("pobi");
        car.move(randomGenerator.getRandomNumber());
        assertThat(car).isEqualTo(Car.createWithPosition("pobi", 1));
    }

    @ParameterizedTest
    @CsvSource({"3","0"})
    @DisplayName("자동차 이동 안됨 테스트")
    void moveFail(int randomNumber) {
        RandomGenerator randomGenerator = new FakeRandomGenerator(randomNumber);
        Car car = Car.create("pobi");
        car.move(randomGenerator.getRandomNumber());
        assertThat(car).isEqualTo(Car.createWithPosition("pobi", 0));
    }
}