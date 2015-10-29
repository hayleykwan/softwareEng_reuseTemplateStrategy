package ic.doc.strategy;

public class TriangleNumberGenerator implements TermGenerator {

    public int term(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Not defined for indices < 0");
        }
        if (i == 0) {
            return 1;
        }
        return (i + 1)*(i + 2) / 2;
    }

}
