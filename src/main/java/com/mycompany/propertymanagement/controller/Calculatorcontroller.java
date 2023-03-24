package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/calculator")
public class Calculatorcontroller {

    //    http://localhost:8080/api/v1/calculator/add?num111=5.5&num222=4.5

    @GetMapping("/add")
    public Double add(@RequestParam("num111") Double num1,@RequestParam("num222") Double num2){
        return num1+num2;
    }

//    http://localhost:8080/api/v1/calculator/sub/4.5/8.5
    @GetMapping("/sub/{num1}/{num2}")
    public Double subStract(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2){
        if(num1>num2){
            return num1-num2;
        }
        else{
            return num2-num1;
        }
    }


//    http://localhost:8080/api/v1/calculator/mul
    @PostMapping("/mul")
    public ResponseEntity<Double> multiplication( @RequestBody CalculatorDTO calculatorDTO ){
        /*
        This is normal way But when we use the POST method we try to create it.
        return calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();

         */
        Double result=calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity=new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }

}
