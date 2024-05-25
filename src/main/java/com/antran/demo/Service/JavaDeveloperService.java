package com.antran.demo.Service;

import com.antran.demo.SoftwareEng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JavaDeveloperService {
    @Autowired
    @Qualifier("java")
    SoftwareEng softwareEng;

    public void service(){
        softwareEng.sayHello();
    }
}
