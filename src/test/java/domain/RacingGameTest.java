package domain;

import domain.port.RandomGenerator;
import mock.FakeRandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @Test
    @DisplayName("게임 생성 테스트")
    void create() {
        String names = "pobi,crong,honux";
        int tryNo = 5;
        RacingGame racingGame = RacingGame.create(names, tryNo);

        assertThat(racingGame).isEqualTo(RacingGame.create(names, tryNo));
    }

    @Test
    @DisplayName("이동 테스트")
    void race() {
        String names = "pobi,crong,honux";

        RandomGenerator randomGenerator = new FakeRandomGenerator(4);
        int tryNo = 5;
        RacingGame racingGame = RacingGame.create(names, tryNo);
        racingGame.race(randomGenerator.getRandomNumber());

        assertThat(racingGame).isEqualTo(RacingGame.createWithPosition(names, tryNo, 1));
    }

    @Test
    @DisplayName("게임 종료 테스트 - 안끝남")
    void isEndFalse() {
        String names = "pobi,crong,honux";
        int count = 5;
        RacingGame racingGame = RacingGame.create(names, count);

        assertThat(racingGame.isEnd()).isFalse();
    }

    @Test
    @DisplayName("게임 종료 테스트 - 끝남")
    void isEndTrue() {
        String names = "pobi,crong,honux";
        int tryNo = 0;
        RacingGame racingGame = RacingGame.create(names, tryNo);

        assertThat(racingGame.isEnd()).isTrue();
    }
}