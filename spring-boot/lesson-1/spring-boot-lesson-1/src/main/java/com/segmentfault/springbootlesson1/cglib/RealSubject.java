package com.segmentfault.springbootlesson1.cglib;

public class RealSubject implements Subject {
    @Override
    public void say() {
        System.out.println("ReanlSubject: hello world.");
    }

    @Override
    public void hello() {
        System.out.println("ReanlSubject: hello lis.");
    }
}
