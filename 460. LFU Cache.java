class LFUCache {
    private int capacity, minFreq = 0;
    private Map<Integer, Integer> vals = new HashMap<>();  // key -> value
    private Map<Integer, Integer> freqs = new HashMap<>(); // key -> use count
    private Map<Integer, LinkedHashSet<Integer>> buckets = new HashMap<>(); // freq -> keys, oldest first

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!vals.containsKey(key)) return -1;
        touch(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (vals.containsKey(key)) { // update counts as a use
            vals.put(key, value);
            touch(key);
            return;
        }

        if (vals.size() == capacity) {
            LinkedHashSet<Integer> set = buckets.get(minFreq);
            int evict = set.iterator().next(); // lowest freq, oldest among ties
            set.remove(evict);
            vals.remove(evict);
            freqs.remove(evict);
        }

        vals.put(key, value);
        freqs.put(key, 1);
        buckets.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1; // a new key always has the lowest frequency
    }

    private void touch(int key) {
        int f = freqs.get(key);
        LinkedHashSet<Integer> set = buckets.get(f);
        set.remove(key);
        if (set.isEmpty()) {
            buckets.remove(f);
            if (minFreq == f) minFreq++; // old min bucket emptied, so min moves up
        }
        freqs.put(key, f + 1);
        buckets.computeIfAbsent(f + 1, k -> new LinkedHashSet<>()).add(key); // newest in its bucket
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
