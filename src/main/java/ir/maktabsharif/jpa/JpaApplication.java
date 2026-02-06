package ir.maktabsharif.jpa;

public class JpaApplication {

    static final Object MONITOR = new Object();

    static void main() throws InterruptedException {

        Signal signal = new Signal();


        new Thread(
                () -> {
                    try {
                        signal.doWait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).start();


        new Thread(
                () -> {
                    try {
                        signal.doWait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).start();

        new Thread(
                () -> {
                    try {
                        Thread.sleep(2000);
                        signal.doNotifyAll();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).start();

        System.out.println("end of main");
    }

    static class Signal {

        public void doWait() throws InterruptedException {
            synchronized (MONITOR) {
                System.out.printf("Thread %s before wait \n", Thread.currentThread().getName());
                MONITOR.wait();
                System.out.printf("Thread %s after wait \n", Thread.currentThread().getName());
            }
        }

        public void doNotify() throws InterruptedException {
            synchronized (MONITOR) {
                System.out.printf("Thread %s before notify \n", Thread.currentThread().getName());
                MONITOR.notify();
                System.out.printf("Thread %s after notify \n", Thread.currentThread().getName());

            }
        }

        public void doNotifyAll() throws InterruptedException {
            synchronized (MONITOR) {
                System.out.printf("Thread %s before notifyAll \n", Thread.currentThread().getName());
                MONITOR.notifyAll();
                System.out.printf("Thread %s after notifyAll \n", Thread.currentThread().getName());

            }
        }
    }

}