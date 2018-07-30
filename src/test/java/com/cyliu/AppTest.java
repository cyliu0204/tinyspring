package com.cyliu;

/**
 * Unit test for simple App.
 */
public class AppTest 

{
    private  HelloService helloService;

    public  AppTest(){
        System.out.println("hello");
    }

    public void sayHi(){
        helloService.sayHello();
    }

}
