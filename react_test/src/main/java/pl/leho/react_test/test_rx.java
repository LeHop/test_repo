package pl.leho.react_test;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 *
 * @author hoppe
 */
public class test_rx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //producer
        Observable<String> observable = Observable.just("how", "to", "do", "in", "java");

        //consumer
        Consumer<? super String> consumer = System.out::println;

        //Attaching producer to consumer
        observable.subscribe(consumer);

        System.out.println("\n");
        Consumer<? super String> consumer1 = System.out::println;
        //Transformation using map() method
        observable.map(w -> w.toUpperCase()).subscribe(consumer);

        System.out.println("\n");
        Consumer<? super Integer> consumer2 = System.out::println;
        observable.map(w -> w.toUpperCase().hashCode()).subscribe(consumer2);
        
        System.out.println("\n");
        Flowable.fromArray(1, 2, 3, 4).subscribe(
        i -> System.out.printf("Entry %d\n", i),
        e -> System.err.printf("Failed to process: %s\n", e),
        () -> System.out.println("Done"));
        
    }

}
