package com.vinaylogics.javaprofiling.events;

import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;

@Name("MyEvent")
@Description("How to create custom events")
public class MyEvent  extends Event {

    @Label("Message")
    String message;

}
