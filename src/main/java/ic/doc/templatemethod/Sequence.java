package ic.doc.templatemethod;

import java.util.Iterator;

abstract class Sequence implements Iterable<Integer> {

    abstract int term(int i);

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
            return term(i++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not implemented");
        }
    }


}
