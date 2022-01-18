package com.tele2.calculator.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CalculatorDTO {
    long id;
    double result;
    String calculation;

    public static CalculatorDTO buildCalculatorDTOFromCalculator(Calculator calculator) {
        return CalculatorDTO.builder()
                .id(calculator.getId())
                .result(calculator.getResult())
                .calculation(calculator.getCalculation()).build();
    }
}
