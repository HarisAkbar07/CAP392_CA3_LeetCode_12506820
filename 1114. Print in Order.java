import java.util.concurrent.Semaphore;

class Foo {
    private Semaphore secondGate = new Semaphore(0); // 0 permits: second() blocks until first() is done
    private Semaphore thirdGate = new Semaphore(0);  // third() blocks until second() is done

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        secondGate.release(); // let second() proceed
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secondGate.acquire(); // wait for first()
        printSecond.run();
        thirdGate.release();  // let third() proceed
    }

    public void third(Runnable printThird) throws InterruptedException {
        thirdGate.acquire(); // wait for second()
        printThird.run();
    }
}
