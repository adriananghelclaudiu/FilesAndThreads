package ro.ctrln.threads;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class CorrectThreads implements Runnable {

    //public int counter = 0;
    private AtomicInteger counter = new AtomicInteger(0);

    public synchronized void incrementCounter() {
        //System.out.println(LocalDateTime.now() + " - " +Thread.currentThread().getName() + " " + counter++);
        //System.out.println(LocalDateTime.now() + " - " +Thread.currentThread().getName() + " " + counter.incrementAndGet());
        System.out.println(Thread.currentThread().getName() + " " + counter.incrementAndGet());
    }

    public static void main(String[] args) {
        CorrectThreads correctThreads = new CorrectThreads();

        Thread threadOne = new Thread(correctThreads);
        Thread threadTwo = new Thread(correctThreads);

        threadOne.start();
        threadTwo.start();
    }

    @Override
    public void run() {
        //while(counter < 1000) {
        while(counter.get() < 1000) {
            incrementCounter();
        }
    }
}
