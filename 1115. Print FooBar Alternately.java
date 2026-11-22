import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore fooTurn = new Semaphore(1); // foo goes first
    private Semaphore barTurn = new Semaphore(0); // bar waits for foo

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooTurn.acquire(); // wait for foo's turn
            printFoo.run();
            barTurn.release(); // hand over to bar
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barTurn.acquire(); // wait for bar's turn
            printBar.run();
            fooTurn.release(); // hand over to foo
        }
    }
}
