package com.yoshino.model;

public abstract class ITest {
    int i = 3;

    private ITest() {}

    protected ITest(int i) {}
}


class Test extends ITest {

    protected Test(int i) {
        super(i);
    }
}