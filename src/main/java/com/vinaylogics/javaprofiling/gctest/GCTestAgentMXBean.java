package com.vinaylogics.javaprofiling.gctest;

public interface GCTestAgentMXBean {

    void newThread(String threadName);
    void newCollectableObject(int size);
    void newLeakedObject(int size);
    void clearLeaked();
    void cpuIntensiveOperation(int iterations);
}
