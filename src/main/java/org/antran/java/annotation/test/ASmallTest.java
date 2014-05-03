package org.antran.java.annotation.test;

import org.antran.java.annotation.test.TestInfo.Priority;

@TestInfo(
        priority = Priority.HIGH,
        createdBy = "An Tran",
        lastModified = "05/04/2014",
        tags = { "dev", "new" })
public class ASmallTest {

    public void test1() {
        throw new RuntimeException();
    }

    @TestCase(enable = false)
    public void test2() {
        throw new RuntimeException();
    }

    @TestCase(enable = true)
    public void test3() {
        throw new RuntimeException();
    }
}
