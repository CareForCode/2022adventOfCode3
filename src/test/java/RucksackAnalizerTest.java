import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RucksackAnalizerTest {

    @ParameterizedTest
    @CsvSource(value = {"a,a,a","d,d,d","de,d,d", "ed,da,d"
            , "vJrwpWtwJgWr,hcsFMMfFFhFp,p","jqHRNqRjqzjGDLGL,rsFMfFZSrLrFZsSL,L"})
    void findDuplicate(String input1, String input2, char expectedResult) {
        char result = RucksackAnalizer.findDuplicate(input1, input2);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"aa,a,a", "abcdef,abc,def"
            , "vJrwpWtwJgWrhcsFMMfFFhFp,vJrwpWtwJgWr,hcsFMMfFFhFp"
            ,"jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL,jqHRNqRjqzjGDLGL,rsFMfFZSrLrFZsSL"})
    void splitStringInMid(String input, String split1, String split2) {
        SplittedString result = RucksackAnalizer.splitStringInMid(input);

        assertThat(result.getString1()).isEqualTo(split1);
        assertThat(result.getString2()).isEqualTo(split2);
    }

    @ParameterizedTest
    @CsvSource(value = {"a,1"})
    void getPriority(char input, int expectedPriority) {
        int priority = RucksackAnalizer.getPriority(input);

        assertThat(priority).isEqualTo(expectedPriority);
    }
}
