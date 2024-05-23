package com.antran.demo.controller;
import com.antran.demo.entity.CalResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Calculator {
    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }

    //add
    // type: http://localhost:8080/add/1/2
    @RequestMapping("/add/{num1}/{num2}")
    public ResponseEntity<CalResult> add(@PathVariable("num1") String num1, @PathVariable("num2") String num2){
        double number1 = validateAndParseDouble(num1);
        double number2 = validateAndParseDouble(num2);
        double res = number1 + number2;
        return new ResponseEntity<>(new CalResult(res), HttpStatus.OK);
    }

    private double validateAndParseDouble(String value){
        try{
            return Double.parseDouble(value);
        }catch (NumberFormatException e){
            throw  new IllegalArgumentException("Invalid input: " + value);
        }
    }

    //mul
    @RequestMapping("/mul/{num1}/{num2}")
    public ResponseEntity<CalResult> mul(@PathVariable("num1") String num1, @PathVariable("num2") String num2){
        double number1 = validateAndParseDouble(num1);
        double number2 = validateAndParseDouble(num2);
        double res = number1 * number2;
        return new ResponseEntity<>(new CalResult(res), HttpStatus.OK);
    }

    //divide
    @RequestMapping("div/{num1}/{num2}")
    public ResponseEntity<CalResult> div(@PathVariable("num1") String num1, @PathVariable("num2") String num2){
        double number1 = validateAndParseDouble(num1);
        double number2 = validateAndParseDouble(num2);
        if(number2 == 0) throw  new ArithmeticException("num2 is zero in yor div operation");
        double res = number1 / number2;
        return new ResponseEntity<>(new CalResult(res), HttpStatus.OK);
    }

    //sub
    @RequestMapping("/sub/{num1}/{num2}")
    public ResponseEntity<CalResult> sub(@PathVariable("num1") String num1, @PathVariable("num2") String num2){
        double number1 = validateAndParseDouble(num1);
        double number2 = validateAndParseDouble(num2);
        double res = number1 - number2;
        return new ResponseEntity<>(new CalResult(res), HttpStatus.OK);
    }
    // terminal -> curl -X GET -H "Content-Type:application/json" -d '{"result:20"}' http://localhost:8080/testObject
    @GetMapping("/testObject")
    public String test(@RequestBody CalResult calResult){
        return calResult.toString();
    }
    //localhost:8080/param?test=myTest
    @RequestMapping("/param")
    public String testParam(@RequestParam("test") String test){
        return test;
    }


}
