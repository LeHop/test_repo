/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.leho.react_test;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;

/**
 *
 * @author hoppe
 */
public class Buffers {

    private static Logger LOGGER = Logger.getLogger(Buffers.class);

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
                ).buffer(threadCt)
                .doFinally(() -> executor.shutdown())
                .subscribe(t -> resultObservableList(t));
    }
    
    public static String intenseCalculation(int i) {
        try {
            Thread.sleep(randInt(50, 200));
            return "el"+i;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private static long randInt(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
    
    private static void resultObservableList(List<String> list){
        System.out.println(list);
    }

}
