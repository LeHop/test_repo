package pl.leho.react_test;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Example4 {

    static ArrayBlockingQueue<String> pool = new ArrayBlockingQueue<String>(5);

    static {
        try {
            pool.put("worker 1");
            pool.put("worker 2");
            pool.put("worker 3");
            pool.put("worker 4");
            pool.put("worker 5");
        } catch (InterruptedException ex) {
            Logger.getLogger(Example4.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) throws InterruptedException {

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("opel", "1995"));
        carList.add(new Car("ford", "2000"));
        carList.add(new Car("citroen", "2012"));
        carList.add(new Car("mercedes", "2013"));
        carList.add(new Car("opel", "1996"));
        carList.add(new Car("ford", "2001"));
        carList.add(new Car("citroen", "2013"));
        carList.add(new Car("mercedes", "2014"));
        carList.add(new Car("opel", "1997"));
        carList.add(new Car("ford", "2002"));
        carList.add(new Car("citroen", "2014"));
        carList.add(new Car("mercedes", "2015"));


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.DAYS, new LinkedBlockingQueue<>(10));
        MyExecutorWrapper myExecutorWrapper = new MyExecutorWrapper(threadPoolExecutor, pool);

        Observable.fromIterable(carList)
                .flatMap(val -> Observable.just(val)
                .subscribeOn(Schedulers.from(myExecutorWrapper))
                .doOnNext(Example4::doWork)
                )
                .buffer(5)
                .doFinally(()->threadPoolExecutor.shutdown())
                .subscribe(t -> printBatchResluts(t));
                

    }
    

    private static void printBatchResluts(List<Car> carList){
        for (Car car : carList) {
            System.out.println(car.getModel()+"/"+car.getYear());
        }
        
    }
    
    private static void resultObservableList(List<List<Car>> list) {
        for (List<Car> list1 : list) {
            for (Car car : list1) {
                System.out.println(car.getModel());
            }
        }
    }

    public static void doWork(Integer i) {
        try {
            System.out.println("Start:  for arg:" + i + " in " + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("Stop: " + Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            Logger.getLogger(Example4.class
                    .getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public static void doWork(Car car) {
        try {
            System.out.println("Start:  for arg:" + car.getModel() + " in " + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("Stop: " + Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            Logger.getLogger(Example4.class
                    .getName()).log(Level.SEVERE, null, ex);

        }
    }

    static class MyExecutorWrapper implements Executor {

        Executor target;
        BlockingQueue<String> resources;

        public MyExecutorWrapper(Executor target, BlockingQueue<String> resources) {
            this.target = target;
            this.resources = resources;
        }

        @Override
        public void execute(Runnable command) {

            try {
                System.out.println("try to aquire resource: in" + Thread.currentThread().getName());
                final String resource = resources.take();
                System.out.println("resource:" + resource + " in" + Thread.currentThread().getName());
                target.execute(new MyRunable(command, () -> {
                    try {
                        resources.put(resource);
                        System.out.println("release resource:" + resource + " in" + Thread.currentThread().getName());
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }));
            } catch (InterruptedException ex) {
                Logger.getLogger(Example4.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    static class MyRunable implements Runnable {

        private Runnable target;
        private Runnable closingRunnable;

        public MyRunable(Runnable target, Runnable closingRunnable) {
            try {
                this.target = target;
            } finally {
                this.closingRunnable = closingRunnable;
            }
        }

        @Override
        public void run() {
            target.run();
            closingRunnable.run();
        }

    }
}
