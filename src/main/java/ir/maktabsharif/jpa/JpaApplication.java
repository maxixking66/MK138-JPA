package ir.maktabsharif.jpa;

import java.util.HashMap;
import java.util.Map;

public class JpaApplication {

    static final Object MONITOR = new Object();

    static Map<Long, Object> lockMap = new HashMap<>();

    static void main() throws InterruptedException {

    }

    static void block(Long chqId) {
        Object lock = lockMap.computeIfAbsent(chqId, _ -> new Object());
        synchronized (lock) {
            System.out.println("block logic");
        }
    }

    static void unblock(Long chqId) {
        Object lock = lockMap.computeIfAbsent(chqId, _ -> new Object());
        synchronized (lock) {
            System.out.println("unblock logic");
        }
    }

    static void approve(Long chqId) {
        Object lock = lockMap.computeIfAbsent(chqId, _ -> new Object());
        synchronized (lock) {
            System.out.println("approve logic");
        }
    }

}