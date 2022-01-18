package com.tele2.calculator.service;

import com.tele2.calculator.dao.CalculatorDao;
import com.tele2.calculator.model.Calculator;
import com.tele2.calculator.model.CalculatorDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    private CalculatorDao dao;

    @Override
    public CalculatorDTO addition(int a, int b) {
        String calculation1 = a + "+" + b;
        List<Calculator> resFromDB = dao.get(calculation1);
        if (!resFromDB.isEmpty()) {
            return CalculatorDTO.buildCalculatorDTOFromCalculator(resFromDB.get(0));
        }
        double result = a + b;
        Calculator newCal = new Calculator(result, calculation1);
        dao.save(newCal);
        return CalculatorDTO.buildCalculatorDTOFromCalculator(newCal);
    }

    @Override
    public CalculatorDTO subtraction(int a, int b) {
        String calculation = a + "-" + b;
        List<Calculator> resFromDB = dao.get(calculation);
        if (!resFromDB.isEmpty()) {
            return CalculatorDTO.buildCalculatorDTOFromCalculator(resFromDB.get(0));
        }
        double result = a - b;
        Calculator newCal = new Calculator(result, calculation);
        dao.save(newCal);
        return CalculatorDTO.buildCalculatorDTOFromCalculator(newCal);
    }

    @Override
    public CalculatorDTO division(int a, int b) {
        String calculation = a + "/" + b;
        List<Calculator> resFromDB = dao.get(calculation);
        if (!resFromDB.isEmpty()) {
            return CalculatorDTO.buildCalculatorDTOFromCalculator(resFromDB.get(0));
        }
        double result = a / b;
        Calculator newCal = new Calculator(result, calculation);
        dao.save(newCal);
        return CalculatorDTO.buildCalculatorDTOFromCalculator(newCal);
    }

    @Override
    public CalculatorDTO multiplication(int a, int b) {
        String calculation = a + "*" + b;
        List<Calculator> resFromDB = dao.get(calculation);
        if (!resFromDB.isEmpty()) {
            return CalculatorDTO.buildCalculatorDTOFromCalculator(resFromDB.get(0));
        }
        double result = a * b;
        Calculator newCal = new Calculator(result, calculation);
        dao.save(newCal);
        return CalculatorDTO.buildCalculatorDTOFromCalculator(newCal);
    }

    @Override
    public List<CalculatorDTO> getAllCalculations() {
        List<CalculatorDTO> allList = new ArrayList<>();
        List<Calculator> fromDB = dao.getAll();
        fromDB.forEach(dto -> allList.add(CalculatorDTO.buildCalculatorDTOFromCalculator(dto)));

        return allList;
    }

}
