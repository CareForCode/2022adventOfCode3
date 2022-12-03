import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RucksackAnalizerTest {

    @ParameterizedTest
    @CsvSource(value = {"a,a,a","d,d,d","de,d,d", "ed,da,d", "vJrwpWtwJgWr,hcsFMMfFFhFp,p","jqHRNqRjqzjGDLGL,rsFMfFZSrLrFZsSL,L"})
    void findDuplicate(String input1, String input2, char expectedResult) {
        char result = RucksackAnalizer.findDuplicate(input1, input2);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void splitStringInMid() {
        SplittedString result = RucksackAnalizer.splitStringInMid("aa");

        assertThat(result.getString1()).isEqualTo("a");
        assertThat(result.getString2()).isEqualTo("a");
    }
}
