package com.vinaylogics.javaprofiling;

public class MyRunner {

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(new MyThread("Thread"+i)).start();
        }
    }
}
