package pl.leho.react_test;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author hoppe
 */
public class Example1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int threadCt = Runtime.getRuntime().availableProcessors() + 1;

        ExecutorService executor = Executors.newFixedThreadPool(threadCt);

        Scheduler scheduler = Schedulers.from(executor);
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("opel", "1995"));
        carList.add(new Car("ford", "2000"));
        carList.add(new Car("citroen", "2012"));
        carList.add(new Car("mercedes", "2013"));

        Observable.fromArray(carList)
                .flatMap(i -> Observable.just(i)
                .subscribeOn(scheduler)
                ).buffer(threadCt)
                .doFinally(() -> executor.shutdown())
                .subscribe(t -> resultObservableList(t));
    }

    private static long randInt(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    private static void resultObservableList(List<List<Car>> list) {
        for (List<Car> list1 : list) {
            for (Car car : list1) {
                System.out.println(car.getModel());
            }
        }
    }

}
