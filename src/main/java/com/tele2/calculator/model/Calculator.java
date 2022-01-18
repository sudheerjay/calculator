package com.tele2.calculator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calculator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    double result;
    String calculation;

    public Calculator(){

    }
    public Calculator(double result, String calculation){
        this.result = result;
        this.calculation = calculation;
    }

    @Override
    public String toString() {
        return String.format(
                "Calculator[id=%d, result='%s', calculation='%s']",
                id, result, calculation);
    }

    public Long getId() {
        return id;
    }

    public double getResult() {
        return result;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setId(long id) {
        this.id=id;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }
}
