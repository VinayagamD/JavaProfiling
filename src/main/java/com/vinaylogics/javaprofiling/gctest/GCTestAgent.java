package com.vinaylogics.javaprofiling.gctest;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GCTestAgent implements GCTestAgentMXBean, Runnable {

    ArrayList<Object> leakingMap = new ArrayList<>();
    volatile double val = 10;

    @Override
    public void newThread(String threadName) {
        Thread newThread = new Thread(this);
        newThread.setName(threadName);
        newThread.start();
    }

    @Override
    public void newCollectableObject(int size) {
        createObject(size);
    }

    private Object createObject(int size) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(LocalDateTime.now() +" "+ i);
        }
        return list;
    }

    @Override
    public void newLeakedObject(int size) {
        leakingMap.add(createObject(size));
    }

    @Override
    public void clearLeaked() {
        leakingMap.clear();
    }

    @Override
    public void cpuIntensiveOperation(int iterations) {
        int[] myArrayToBeSorted = new int[] {4,2,6,7,2,1,6};
        for (int i = 0; i < iterations; i++) {
            for (int j = 0; j < myArrayToBeSorted.length-1; j++) {
                myArrayToBeSorted[j] = myArrayToBeSorted[j]+myArrayToBeSorted[j+1];
            }
        }
    }

    @Override
    public void run() {
        for (;;) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
