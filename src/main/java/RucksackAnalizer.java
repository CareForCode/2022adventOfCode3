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

    public static int getRucksackPriorityForDuplicatedItem(String input) {
        SplittedString splittedString = splitStringInMid(input);
        char duplicate = findDuplicate(splittedString.getString1(), splittedString.getString2());
        return getPriority(duplicate);
    }

    public static char getBadgeForThreeElfGroup(String input1, String input2, String input3) {
        for (char char1 : input1.toCharArray()) {
            for (char char2 : input2.toCharArray()) {
                if (char1 == char2) {
                    for (char char3 : input3.toCharArray()) {
                        if (char1 == char3) {
                            return char1;
                        }
                    }
                }
            }
        }
        return Character.MIN_VALUE;
    }
}
