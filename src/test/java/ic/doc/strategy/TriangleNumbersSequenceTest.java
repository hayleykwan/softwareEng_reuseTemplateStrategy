package ic.doc.strategy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class TriangleNumbersSequenceTest {

    private final Sequence triangleNumbersSequence = new Sequence(new TriangleNumberGenerator());

    @Test
    public void definesFirstTermToBeOne() {

        assertThat(triangleNumbersSequence.termGenerator.term(0), is(1));

    }

    @Test
    public void definesSubsequentTermsToFollowFormula() {

        assertThat(triangleNumbersSequence.termGenerator.term(1), is(3));
        assertThat(triangleNumbersSequence.termGenerator.term(2), is(6));
        assertThat(triangleNumbersSequence.termGenerator.term(3), is(10));
    }

    @Test
    public void isUndefinedForNegativeIndices() {

        try {
            triangleNumbersSequence.termGenerator.term(-1);
            fail("should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Not defined for indices < 0"));
        }
    }

    @Test
    public void canBeIteratedThrough() {

        assertThat(triangleNumbersSequence, hasItems(1, 3, 6, 10, 15));
    }

}