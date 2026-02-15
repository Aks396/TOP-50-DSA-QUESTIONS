package ConcurrencyProblems;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Question 3: Deep Dive into ReentrantLock and ReadWriteLock
 */
public class LockingMechanisms {
    private int count = 0;
    private final Lock lock = new ReentrantLock();
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void incrementSync() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCountWithReadLock() {
        rwLock.readLock().lock();
        try {
            return count;
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        LockingMechanisms demo = new LockingMechanisms();

        // Demo basic reentrant lock
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                demo.incrementSync();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                demo.incrementSync();
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        System.out.println("Final Count (with ReentrantLock): " + demo.count);
        System.out.println("Read consistency check: " + demo.getCountWithReadLock());
    }
}
