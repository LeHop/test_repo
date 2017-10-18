/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.leho.react_test;

/**
 *
 * @author hoppe
 */
public class SingleThread extends Thread{
    private String name;

    public SingleThread(String phone) {
        this.name = phone;
    }
        
    @Override
    public void run() {
        System.out.println(name);
    }
}
