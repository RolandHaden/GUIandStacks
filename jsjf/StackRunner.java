/*
Name: Davis Haden
Date Last Edited: 10/24/2021
Desc: StackRunner class. Runs the different stack classes. One is commented out for simpler use.
*/
package jsjf;

public class StackRunner {
    public static void main(String[] args){
        /*ArrayStack<String> names = new ArrayStack<String>();
        names.push("Davis");
        names.push("Phoebe");
        names.push("Morgan");
        System.out.println(names.pop());
        System.out.println(names.isEmpty());
        System.out.println(names.size());
        System.out.println(names);*/
        CircleStack<String> names = new CircleStack<>();
        names.push("Davis");
        names.push("Gabi");
        names.push("Sam");
        names.push("Bean");
        names.push("Nicki");
        names.push("Toaster Oven");
        System.out.println("Size: " + names.size());
        System.out.println(names);
    }
}
