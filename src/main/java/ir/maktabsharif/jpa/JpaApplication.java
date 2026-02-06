package ir.maktabsharif.jpa;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JpaApplication {

    static void main() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> submit = executorService.submit(
                () -> {
                    System.out.println("start");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("end");
                    return "mohsen";
                }
        );
        String result = submit.get();
        System.out.println("end of main with result: " + result);
        executorService.shutdown();
    }


}