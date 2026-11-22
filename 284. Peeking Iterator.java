class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> it;
    private Integer nextVal; // cached upcoming element, null when exhausted

    public PeekingIterator(Iterator<Integer> iterator) {
        it = iterator;
        nextVal = it.hasNext() ? it.next() : null; // pre-fetch first element
    }

    public Integer peek() {
        return nextVal; // look without advancing
    }

    @Override
    public Integer next() {
        Integer res = nextVal;
        nextVal = it.hasNext() ? it.next() : null; // refill the cache
        return res;
    }

    @Override
    public boolean hasNext() {
        return nextVal != null;
    }
}
