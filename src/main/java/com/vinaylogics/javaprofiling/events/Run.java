package com.vinaylogics.javaprofiling.events;

public class Run {

    public static void main(String[] args) {
        MyEvent event = new MyEvent();
        event.begin();
        event.message = "Hi There, I am an event...";
        event.commit();
    }
}
