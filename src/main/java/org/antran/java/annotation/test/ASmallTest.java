package org.antran.java.annotation.test;

import org.antran.java.annotation.test.TestInfo.Priority;

@TestInfo(
        priority = Priority.HIGH,
        createdBy = "An Tran",
        lastModified = "05/04/2014",
        tags = { "dev", "new" })
public class ASmallTest {

    @TestCase
    public void testPassed() {
        System.out.println("Passed");
    }

    @TestCase(enable = false)
    public void testDisabled() {
        throw new RuntimeException();
    }

    @TestCase(enable = true)
    public void testFailed() {
        throw new RuntimeException();
    }
}
