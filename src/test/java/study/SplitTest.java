package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 학습 목적으로 만든 테스트
public class SplitTest {

    @Test
    void split() {
        String[] values = "1".split(",");
        assertThat(values).isEqualTo(new String[]{"1"});

        values = "1,2".split(",");
        assertThat(values).isEqualTo(new String[]{"1", "2"});
    }
}
