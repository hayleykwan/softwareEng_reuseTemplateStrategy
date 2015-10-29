package ic.doc.strategy;

import java.util.Iterator;

class Sequence implements Iterable<Integer>  {

    TermGenerator termGenerator;

    Sequence(TermGenerator termGenerator){
        this.termGenerator = termGenerator;
    }

    public Iterator<Integer> iterator() {
        return new SequenceIterator();
    }

    class SequenceIterator implements Iterator<Integer> {

        private int i = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return termGenerator.term(i++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not implemented");
        }
    }
}
