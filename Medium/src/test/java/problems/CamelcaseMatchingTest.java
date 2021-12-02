package problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



class CamelcaseMatchingTest {

    private CamelcaseMatching matching = new CamelcaseMatching();
    public static final String PATTERN = "FB";
    public static final String PATTERN_WITH_LOWER_CASE = "FoBa";
    public static final String PATTERN_BIG = "FoBaT";
    public static final String PATTERN_LEET = "CooP";

    @Test
    void should_match_for_leet_words() {

        String[] queries = {"ControlPanel"};
        assertThat(getActual(queries, PATTERN_LEET), contains( true));
    }

    private List<Boolean> getActual(String[] queries, String patternLeet) {
        return matching.camelMatch(queries, patternLeet);
    }

    @Test
    void should_match_for_one_word() {

        String[] queries = {"FooBar"};
        assertTrue(getActual(queries, PATTERN).get(0));
        assertTrue(getActual(queries, PATTERN_WITH_LOWER_CASE).get(0));
        assertFalse(getActual(queries, PATTERN_BIG).get(0));

    }

    @Test
    void should_match_for_no_words() {

        String[] queries = {};
        assertTrue(getActual(queries, PATTERN).isEmpty());
        assertTrue(getActual(queries, PATTERN_WITH_LOWER_CASE).isEmpty());
        assertTrue(getActual(queries, PATTERN_BIG).isEmpty());

    }

    @Test
    void should_match_for_capital_after() {

        String[] queries = {"FooBarTest"};
        assertFalse(getActual(queries, PATTERN).get(0));
        assertFalse(getActual(queries, PATTERN_WITH_LOWER_CASE).get(0));

    }

    @Test
    void should_match_for_capital_between_words() {

        String[] queries = {"ForceFeedBack"};
        assertFalse(getActual(queries, PATTERN).get(0));
        assertFalse(getActual(queries, PATTERN_WITH_LOWER_CASE).get(0));
        assertFalse(getActual(queries, PATTERN_BIG).get(0));

    }

    @Test
    void should_match_for_capital_after_matching_pattern() {

        String[] queries = {"ForceBackFeed"};
        assertFalse(getActual(queries, PATTERN).get(0));
        assertFalse(getActual(queries, PATTERN).get(0));
        assertFalse(getActual(queries, PATTERN_BIG).get(0));

    }

    @Test
    void should_match_for_capital_before_matching_pattern() {

        String[] queries = {"AForceBackFeed"};
        assertFalse(getActual(queries, PATTERN).get(0));
        assertFalse(getActual(queries, PATTERN).get(0));
        assertFalse(getActual(queries, PATTERN_BIG).get(0));

    }

    @Test
    void should_match_for_one_word_with_lower_case() {

        String[] queries = {"FooBra"};
        assertTrue(getActual(queries, PATTERN_WITH_LOWER_CASE).get(0));
        assertFalse(getActual(queries, PATTERN_BIG).get(0));

    }

    @Test
    void should_match_for_one_word_with_lower_case_at_beginning() {

        String[] queries = {"rFooBa"};
        assertTrue(getActual(queries, PATTERN_WITH_LOWER_CASE).get(0));
        assertFalse(getActual(queries, PATTERN_BIG).get(0));

    }

    @Test
    void should_match_for_one_word_with_mix_letter_cases() {

        String[] queries = {"FootBallcourT"};
        assertFalse(getActual(queries, PATTERN_WITH_LOWER_CASE).get(0));
        assertTrue(getActual(queries, PATTERN_BIG).get(0));

    }

    @Test
    void should_match_for_one_word_with_mix_letter_cases_but_no_lower() {

        String[] queries = {"FootBllcourT"};
        assertFalse(getActual(queries, PATTERN_WITH_LOWER_CASE).get(0));
        assertFalse(getActual(queries, PATTERN_BIG).get(0));

    }
}