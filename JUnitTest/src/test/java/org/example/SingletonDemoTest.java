package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonDemoTest {
    @Test
    public void testSingletonDemo() {
        SingletonDemo singletonDemo = SingletonDemo.getSingleton();
        SingletonDemo singletonDemo1 = SingletonDemo.getSingleton();
       /* Assertions.assertNotNull(singletonDemo);
        Assertions.assertNotNull(singletonDemo1);*/
        if (singletonDemo == null || singletonDemo1 == null)
            Assertions.fail("The given object reference should not be null");
        Assertions.assertSame(singletonDemo, singletonDemo1);
    }
}
