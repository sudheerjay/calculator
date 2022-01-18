package com.tele2.calculator.service;

import com.tele2.calculator.model.CalculatorDTO;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {
    CalculatorDTO addition(int a, int b);
    CalculatorDTO subtraction(int a, int b);
    CalculatorDTO division(int a, int b);
    CalculatorDTO multiplication(int a, int b);
    List<CalculatorDTO> getAllCalculations();
}
