package pl.leho.react_test;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 *
 * @author hoppe
 */
public class from {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList myArrayList = new ArrayList();
        myArrayList.add("One");
        myArrayList.add("Two");
        myArrayList.add("Three");
        myArrayList.add("Four");
        
        Observable myObservable = Observable.fromArray(myArrayList);
        
        Consumer myCustomer = new Consumer() {
            @Override
            public void accept(Object t) throws Exception {
                System.out.println(t);
            }
        };
        
        myObservable.subscribe(myCustomer);
    }
    
}
