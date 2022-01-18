package com.tele2.calculator.dao;

import com.tele2.calculator.model.Calculator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

@Component
public class CalculatorDao implements Tele2Dao<Calculator> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public List<Calculator> get(String calculation) {
        List<Calculator> calculator = jdbcTemplate.query("select * from calculator where calculation = ?",
                new Object[]{calculation}, new CalculatorRowMapper());
        return calculator;
    }

    @Override
    @Transactional
    public List getAll() {
        List<Calculator> calculator = (List<Calculator>) jdbcTemplate.query("select * from calculator",
                new CalculatorRowMapper());
        return calculator;
    }

    @Override
    @Transactional
    public void save(Calculator cal) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("calculator").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<String, Object>(2);
        parameters.put("result", cal.getResult());
        parameters.put("calculation", cal.getCalculation());
        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
    }
}
