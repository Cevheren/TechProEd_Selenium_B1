package com.techproed.paralelTesting;

import org.testng.annotations.Test;

public class Test2 {
    @Test
    public void method4(){
        System.out.println("This is method 4");
        System.out.println("Thread ID of method 4 : "+Thread.currentThread().getId());
    }

    @Test
    public void method5(){
        System.out.println("This is method 5");
        System.out.println("Thread ID of method 5 : "+Thread.currentThread().getId());
    }

}
