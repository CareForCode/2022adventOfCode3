public class RucksackAnalizer {

    private RucksackAnalizer(){}
    public static char findDuplicate(String input1, String input2) {
        for (char char1 : input1.toCharArray()) {
            for (char char2 : input2.toCharArray()) {
                if (char1 == char2) {
                    return char1;
                }
            }
        }
        return Character.MIN_VALUE;
    }

    public static SplittedString splitStringInMid(String input) {
        return new SplittedString("a","a");
    }
}
