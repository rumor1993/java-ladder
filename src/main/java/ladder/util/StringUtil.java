package ladder.util;

import java.util.Optional;

public class StringUtil {
    private static final String NON_INPUT = "입력을 하지 않았습니다";
    private static String delimiter = ",";

    private StringUtil (){}
    public static String[] splitNames(String names) {
        String[] splitNames = Optional.ofNullable(names)
                .map((element) -> element.split(delimiter))
                .filter(namesOpt -> namesOpt.length > 1)
                .orElseThrow(() -> new NullPointerException(NON_INPUT));
        return splitNames;
    }
}
