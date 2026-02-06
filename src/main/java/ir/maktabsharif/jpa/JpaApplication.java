package ir.maktabsharif.jpa;

import ir.maktabsharif.jpa.util.CustomLock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JpaApplication {

    static Map<Integer, CustomLock> lockMap = new ConcurrentHashMap<>();

    static void main() throws InterruptedException {

        Thread block = new Thread(
                () -> {
                    try {
                        block(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, "block"
        );

        Thread unblock = new Thread(
                () -> {
                    try {
                        unblock(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, "unblock"
        );

        Thread approve = new Thread(
                () -> {
                    try {
                        approve(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, "approve"
        );

        block.start();
        unblock.start();
        approve.start();


        block.join();
        unblock.join();
        approve.join();
        System.out.println("end of main");
    }

    static void block(Integer chqId) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start");
        CustomLock lock = lockMap.computeIfAbsent(chqId, _ -> new CustomLock());
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("block");
        } finally {
            lock.unlock();
        }
    }

    static void unblock(Integer chqId) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start");
        CustomLock lock = lockMap.computeIfAbsent(chqId, _ -> new CustomLock());
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("unblock");
        } finally {
            lock.unlock();
        }
    }

    static void approve(Integer chqId) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start");
        CustomLock lock = lockMap.computeIfAbsent(chqId, _ -> new CustomLock());
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("approve");
        } finally {
            lock.unlock();
        }
    }

}