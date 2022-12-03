import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

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
    @CsvSource(value = {"a,1","b,2","A,27","p,16","L,38","P,42"})
    void getPriority(char input, int expectedPriority) {
        int priority = RucksackAnalizer.getPriority(input);

        assertThat(priority).isEqualTo(expectedPriority);
    }

    @ParameterizedTest
    @CsvSource(value = {"aa,1","vJrwpWtwJgWrhcsFMMfFFhFp,16","jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL,38"})
    void getRucksackPriorityForDuplicatedItem(String input, int expectedPriority) {
        int priority = RucksackAnalizer.getRucksackPriorityForDuplicatedItem(input);

        assertThat(priority).isEqualTo(expectedPriority);
    }

    @ParameterizedTest
    @CsvSource(value = {"a,a,a,a","bac,dbe,lhb,b","vJrwpWtwJgWrhcsFMMfFFhFp,jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL,PmmdzqPrVvPwwTWBwg,r"})
    void getBadgePriorityForThreeElfGroup(String input1, String input2, String input3, char expectedDuplicate) {
        char result = RucksackAnalizer.getBadgePriorityForThreeElfGroup(input1, input2, input3);

        assertThat(result).isEqualTo(expectedDuplicate);
    }

    @Test
    void result1() {
        BufferedReader reader;
        int totalSum = 0;

        try {
            reader = new BufferedReader(new FileReader("src/test/resources/adventOfCode3Input.txt"));
            String line = reader.readLine();
            while (line != null) {
                totalSum += RucksackAnalizer.getRucksackPriorityForDuplicatedItem(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(totalSum).isEqualTo(7903);
    }
}
