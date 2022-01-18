package com.tele2.calculator.dao;

import com.tele2.calculator.model.Calculator;
import com.tele2.calculator.model.CalculatorDTO;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatorRepository extends CrudRepository<Calculator, Long> {

    List<Calculator> findByCalculation(String calculation);

    CalculatorDTO findById(long id);
}
