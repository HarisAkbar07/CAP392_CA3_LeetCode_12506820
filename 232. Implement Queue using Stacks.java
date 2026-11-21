class MyQueue {
    private Deque<Integer> in = new ArrayDeque<>();  // receives pushes
    private Deque<Integer> out = new ArrayDeque<>(); // serves pops/peeks

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        move();
        return out.pop();
    }

    public int peek() {
        move();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void move() {
        if (out.isEmpty()) {         // refill only when out is drained
            while (!in.isEmpty()) {
                out.push(in.pop());  // reversing order makes oldest element the top
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
