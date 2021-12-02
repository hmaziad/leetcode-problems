package problems;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        return Stream
                .of(queries)
                .map(String::toCharArray)
                .map(arr -> matches(arr, pattern.toCharArray()))
                .collect(Collectors.toList());
    }

    private boolean matches(char[] chars, char[] pattern) {
        int i = 0;
        int j = 0;

        while (i < chars.length) {

            if (j < pattern.length) {

                if (chars[i] != pattern[j] && (Character.isUpperCase(chars[i]))) {
                    return false;
                }

                if (chars[i++] == pattern[j]) {
                    j++;
                }

                continue;
            }

            if (Character.isUpperCase(chars[i++])) {
                return false;
            }

        }

        return j == pattern.length;
    }

}
