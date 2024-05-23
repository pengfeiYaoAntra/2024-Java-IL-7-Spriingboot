package com.antran.demo.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor


public class CalResult {
    private double result;
    //100
    public CalResult(double result){
        this.result = result;
    }


    @Override
    public String toString() {
        return "Cal result is {" + result + "}";
    }
}
