class BrowserHistory {
    private List<String> pages = new ArrayList<>();
    private int cur = 0;  // index of current page
    private int last = 0; // index of last valid page for forward()

    public BrowserHistory(String homepage) {
        pages.add(homepage);
    }

    public void visit(String url) {
        cur++;
        if (cur < pages.size()) pages.set(cur, url); // overwrite old forward history
        else pages.add(url);
        last = cur; // anything after cur is now discarded
    }

    public String back(int steps) {
        cur = Math.max(0, cur - steps); // clamp at the first page
        return pages.get(cur);
    }

    public String forward(int steps) {
        cur = Math.min(last, cur + steps); // clamp at the last valid page
        return pages.get(cur);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
