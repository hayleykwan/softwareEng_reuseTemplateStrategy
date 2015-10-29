package ic.doc.strategy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class FibonacciSequenceTest {

    final Sequence sequence = new Sequence(new FibonacciNumberGenerator());

    @Test
    public void definesFirstTwoTermsToBeOne() {

        assertThat(sequence.termGenerator.term(0), is(1));
        assertThat(sequence.termGenerator.term(1), is(1));
    }

    @Test
    public void definesSubsequentTermsToBeTheSumOfThePreviousTwo() {

        assertThat(sequence.termGenerator.term(2), is(2));
        assertThat(sequence.termGenerator.term(3), is(3));
        assertThat(sequence.termGenerator.term(4), is(5));
    }

    @Test
    public void isUndefinedForNegativeIndices() {

        try {
            sequence.termGenerator.term(-1);
            fail("should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Not defined for indices < 0"));
        }
    }

    @Test
    public void canBeIteratedThrough() {

        assertThat(sequence, hasItems(1, 1, 2, 3, 5));
    }

}