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
public class FunctionTRIdentityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Function<Employee, String> funcEmpToString = (Employee e) -> {
            return e.getName();
        };
        List<Employee> employeeList
                = Arrays.asList(new Employee("Tom Jones", 45),
                        new Employee("Harry Major", 25),
                        new Employee("Ethan Hardy", 65),
                        new Employee("Nancy Smith", 15),
                        new Employee("Deborah Sprightly", 29));
        List<Employee> empNameListInitials = applyIdentityToEmpList(employeeList, Function.identity());
        empNameListInitials.forEach(System.out::println);
    }

    public static List<Employee> applyIdentityToEmpList(List<Employee> employeeList, Function<Employee, Employee> funcEmpToEmp) {
        List<Employee> empNameList = new ArrayList<Employee>();
        for (Employee emp : employeeList) {
            empNameList.add(funcEmpToEmp.apply(emp));
        }
        return empNameList;
    }
}
