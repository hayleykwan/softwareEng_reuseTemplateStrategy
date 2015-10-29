package ic.doc.strategy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class FibonacciSequenceTest {

    private final Sequence fibonacciSequence = new Sequence(new FibonacciNumberGenerator());

    @Test
    public void definesFirstTwoTermsToBeOne() {

        assertThat(fibonacciSequence.termGenerator.term(0), is(1));
        assertThat(fibonacciSequence.termGenerator.term(1), is(1));
    }

    @Test
    public void definesSubsequentTermsToBeTheSumOfThePreviousTwo() {

        assertThat(fibonacciSequence.termGenerator.term(2), is(2));
        assertThat(fibonacciSequence.termGenerator.term(3), is(3));
        assertThat(fibonacciSequence.termGenerator.term(4), is(5));
    }

    @Test
    public void isUndefinedForNegativeIndices() {

        try {
            fibonacciSequence.termGenerator.term(-1);
            fail("should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Not defined for indices < 0"));
        }
    }

    @Test
    public void canBeIteratedThrough() {

        assertThat(fibonacciSequence, hasItems(1, 1, 2, 3, 5));
    }

}