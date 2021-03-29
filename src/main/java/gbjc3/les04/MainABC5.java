package gbjc3.les04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainABC5 {
    private static final Object key = new Object();
    private static final int NUMBER = 5;
    public static volatile char symbol = 'A';

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(()->{
            try {
                for (int i = 0; i < NUMBER; i++) {
                    synchronized (key) {
                        while (symbol != 'A') {
                            key.wait();
                        }
                        System.out.print("A");
                        symbol = 'B';
                        key.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.submit(()->{
            try {
                for (int i = 0; i < NUMBER; i++) {
                    synchronized (key) {
                        while (symbol != 'B') {
                            key.wait();
                        }
                        System.out.print("B");
                        symbol = 'C';
                        key.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.submit(()->{
            try {
                for (int i = 0; i < NUMBER; i++) {
                    synchronized (key) {
                        while (symbol != 'C') {
                            key.wait();
                        }
                        System.out.print("C");
                        symbol = 'A';
                        key.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }
}
