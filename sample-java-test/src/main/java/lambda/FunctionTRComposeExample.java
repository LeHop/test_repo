/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author hoppe
 */
public class FunctionTRComposeExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Function<Employee, String> funcEmpToString = (Employee e) -> {
            return e.getName();
        };
        
        Function<Employee, Employee> funcEmpFirstName
                = (Employee e) -> {
                    int index = e.getName().indexOf(" ");
                    String firstName = e.getName().substring(0, index);
                    e.setName(firstName);
                    return e;
                };
        
        List<Employee> employeeList
                = Arrays.asList(new Employee("Tom Jones", 45),
                        new Employee("Harry Major", 25),
                        new Employee("Ethan Hardy", 65),
                        new Employee("Nancy Smith", 15),
                        new Employee("Deborah Sprightly", 29));
        
        List<String> empFirstNameList = convertEmpListToNamesList(employeeList, funcEmpToString.compose(funcEmpFirstName));
        
        empFirstNameList.forEach(str -> {
            System.out.print(" " + str);
        });
    }

    public static List<String> convertEmpListToNamesList(List<Employee> employeeList, Function<Employee, String> funcEmpToString) {
        List<String> empNameList = new ArrayList<String>();
        for (Employee emp : employeeList) {
            empNameList.add(funcEmpToString.apply(emp));
        }
        return empNameList;
    }
}
