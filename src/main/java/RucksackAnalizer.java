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
        String split1 = input.substring(0, input.length() / 2);
        String split2 = input.substring(input.length() / 2);
        return new SplittedString(split1,split2);
    }

    public static int getPriority(char input) {
        if (Character.isLowerCase(input)) {
            return input-96;
        }
        return input-38;
    }
}
