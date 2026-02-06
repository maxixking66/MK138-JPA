package ir.maktabsharif.jpa.util;

public class CustomLock {

    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " try to lock");
        while (isLocked) {
            wait();
        }
        this.isLocked = true;
        System.out.println(Thread.currentThread().getName() + " locked");
    }

    public synchronized void unlock() {
        System.out.println(Thread.currentThread().getName() + " try to unlock");
        if (isLocked) {
            this.isLocked = false;
            notify();
            System.out.println(Thread.currentThread().getName() + " unlocked");
        }
    }
}
