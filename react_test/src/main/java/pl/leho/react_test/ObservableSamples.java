/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.leho.react_test;

import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoppe
 */
public class ObservableSamples {
     public static void main(String[] args) {
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
        
        Observable.fromIterable(carList)
                .flatMap(val -> Observable.just(val))
                .buffer(5)
                .subscribe(t -> printBatchResluts(t)); 
        
     }
     
     private static void printBatchResluts(List<Car> carList){
        for (Car car : carList) {
            System.out.println(car.getModel()+"/"+car.getYear());
        }
        
    }
}
