import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RucksackAnalizerTest {

    @Test
    void findDuplicate() {
        String result = RucksackAnalizer.findDuplicate("a", "a");

        assertThat(result).isEqualTo("a");
    }

    @Test
    void findDuplicate2() {
        String result = RucksackAnalizer.findDuplicate("d", "d");

        assertThat(result).isEqualTo("d");
    }

    @Test
    void findDuplicate3() {
        String result = RucksackAnalizer.findDuplicate("de", "d");

        assertThat(result).isEqualTo("d");
    }
}
