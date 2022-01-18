package com.tele2.calculator.dao;

import com.tele2.calculator.model.Calculator;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CalculatorRowMapper implements RowMapper<Calculator> {
    public Calculator mapRow(ResultSet rs, int row) throws SQLException {
        Calculator calculator = new Calculator();
        calculator.setId(rs.getLong("id"));
        calculator.setResult(rs.getDouble("result"));
        calculator.setCalculation(rs.getString("calculation"));
        return calculator;
    }
}
