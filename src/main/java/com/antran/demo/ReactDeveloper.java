package com.antran.demo;

import org.springframework.stereotype.Component;

@Component("react")
public class ReactDeveloper implements SoftwareEng{
    @Override
    public void sayHello() {
        System.out.println("Hello, I am react");
    }
}
