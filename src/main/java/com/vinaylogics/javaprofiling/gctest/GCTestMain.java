package com.vinaylogics.javaprofiling.gctest;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class GCTestMain {

    public static void main(String[] args) throws Exception {
        init();
        for (;;) {
            Thread.sleep(1000);
        }
    }

    private static void init() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer mbs = null;
        mbs  = ManagementFactory.getPlatformMBeanServer();
        GCTestAgent agent = new GCTestAgent();
        ObjectName agentName;
        agentName = new ObjectName("VTests:name=GCTestAgent");
        mbs.registerMBean(agent,agentName);
    }
}
