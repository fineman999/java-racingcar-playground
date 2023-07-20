package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:3", "pobi:1"}, delimiter = ':')
    @DisplayName("자동차 생성 테스트")
    void create(String names, int size) {
        Cars cars = Cars.create(names);

        assertThat(cars.size()).isEqualTo(size);
        assertThat(cars).isEqualTo(Cars.create(names));
    }



}