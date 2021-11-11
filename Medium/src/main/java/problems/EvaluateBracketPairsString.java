package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
// https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
public class EvaluateBracketPairsString {
    public static void main(String[] args) {

        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = List.of(List.of("name", "bob"), List.of("age", "two"));
        System.out.println(evaluate(s, knowledge));
    }

    public static String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> knowledgeMap = new HashMap<>();
        knowledge.stream().forEach(pair -> knowledgeMap.put(pair.get(0), pair.get(1)));

        boolean isBuildingKey = false;
        char OPENING_BRACKET = '(';
        char CLOSING_BRACKET = ')';
        StringBuilder result = new StringBuilder();
        List<Character> keyChars = new ArrayList<>();

        for (char ch : s.toCharArray()) {

            if (ch == OPENING_BRACKET) {
                isBuildingKey = true;
                continue;
            }

            if (ch == CLOSING_BRACKET) {
                isBuildingKey = false;
                result.append(knowledgeMap.getOrDefault(asString(keyChars),"?"));
                keyChars.clear();
                continue;
            }

            if (isBuildingKey) {
                keyChars.add(ch);
                continue;
            }

            result.append(ch);

        }
        return result.toString();
    }

    private static String asString(List<Character> str) {
        return  str.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}
