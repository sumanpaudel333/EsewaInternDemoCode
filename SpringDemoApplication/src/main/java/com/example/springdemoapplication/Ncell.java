package com.example.springdemoapplication;

public class Ncell implements Sim {

    @Override
    public void calling() {
        System.out.println("Calling from Ncell Sim");
    }

    @Override
    public void data() {
        System.out.println("Using data from Ncell Sim");
    }
    public void msg(){
        System.out.println("This is msg demo");
    }
}
