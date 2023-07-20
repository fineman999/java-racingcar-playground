package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("Position 0 생성")
    void startFromZero() {
        Position position = Position.startFromZero();
        assertThat(position).isEqualTo(Position.startFromZero());
    }

}