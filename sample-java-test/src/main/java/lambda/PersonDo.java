/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

/**
 *
 * @author hoppe
 */
public class PersonDo {
     public static void main(String[] args) throws InterruptedException {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person.getFirstName() +" "+ person.getLastName());
        
        
    }
}
