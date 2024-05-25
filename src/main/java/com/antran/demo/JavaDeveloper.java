package com.antran.demo;

import org.springframework.stereotype.Component;

@Component("java")
public class JavaDeveloper implements SoftwareEng{
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Java");
    }
}
