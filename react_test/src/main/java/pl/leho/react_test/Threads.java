/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.leho.react_test;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;

/**
 *
 * @author hoppe
 */
public class Threads {

    private static Logger LOGGER = Logger.getLogger(Threads.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int threadCt = Runtime.getRuntime().availableProcessors() + 1;

        ExecutorService executor = Executors.newFixedThreadPool(threadCt);
        Scheduler scheduler = Schedulers.from(executor);

        Observable.range(1, 100)
                .flatMap(i -> Observable.just(i)
                .subscribeOn(scheduler)
                .map(i2 -> intenseCalculation(i2))
                ).doFinally(() -> executor.shutdown())
                .subscribe(System.out::println);
    }

    public static String intenseCalculation(int i) {
        try {
            Thread.sleep(randInt(100, 500));
            return "Calculating " + i + " finished " + Thread.currentThread().getName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private static long randInt(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

}
