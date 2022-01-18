package com.tele2.calculator.service;

import com.tele2.calculator.dao.CalculatorDao;
import com.tele2.calculator.model.Calculator;
import com.tele2.calculator.model.CalculatorDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceImplUTest {

    @Mock
    private CalculatorDao daoMock;

    @InjectMocks
    private CalculatorServiceImpl service;

    Calculator cal;

    @BeforeEach
    void setup() {
        daoMock = Mockito.mock(CalculatorDao.class);
        service = new CalculatorServiceImpl(daoMock);
        cal = new Calculator();
    }

    @Test
    @DisplayName("Test addition when DB already has record")
    void test_AdditionWhenDBHasRecord() {
        cal.setId(1);
        cal.setResult(15.0);
        cal.setCalculation("10+5");
        List<Calculator> calList = new ArrayList<>();
        calList.add(cal);
        doReturn(calList).when(daoMock).get("10+5");
        CalculatorDTO calDTO = service.addition(10, 5);

        Assertions.assertEquals(cal.getResult(), calDTO.getResult());
    }

    @Test
    @DisplayName("Test addition")
    void test_AdditionWhenDBDoesNotHaveRecord() {

        List<Calculator> calList = new ArrayList<>();
        doReturn(new ArrayList<>()).when(daoMock).get("10+5");
        CalculatorDTO calDTO = service.addition(10, 5);

        Assertions.assertEquals(15.0, calDTO.getResult());
    }

    @Test
    @DisplayName("Test subtraction when DB already has record")
    void test_SubtractionWhenDBHasRecord() {
        cal.setId(1);
        cal.setResult(5.0);
        cal.setCalculation("10-5");
        List<Calculator> calList = new ArrayList<>();
        calList.add(cal);
        doReturn(calList).when(daoMock).get("10-5");
        CalculatorDTO calDTO = service.subtraction(10, 5);

        Assertions.assertEquals(cal.getResult(), calDTO.getResult());
    }

    @Test
    @DisplayName("Test addition")
    void test_SubtractionWhenDBDoesNotHaveRecord() {

        List<Calculator> calList = new ArrayList<>();
        doReturn(new ArrayList<>()).when(daoMock).get("10-5");
        CalculatorDTO calDTO = service.subtraction(10, 5);

        Assertions.assertEquals(5.0, calDTO.getResult());
    }
    @Test
    @DisplayName("Test multiplication when DB already has record")
    void test_MultiplicationWhenDBHasRecord() {
        cal.setId(1);
        cal.setResult(50.0);
        cal.setCalculation("10*5");
        List<Calculator> calList = new ArrayList<>();
        calList.add(cal);
        doReturn(calList).when(daoMock).get("10*5");
        CalculatorDTO calDTO = service.multiplication(10, 5);

        Assertions.assertEquals(cal.getResult(), calDTO.getResult());
    }

    @Test
    @DisplayName("Test multiplication")
    void test_multiplicationWhenDBDoesNotHaveRecord() {

        List<Calculator> calList = new ArrayList<>();
        doReturn(new ArrayList<>()).when(daoMock).get("10*5");
        CalculatorDTO calDTO = service.multiplication(10, 5);

        Assertions.assertEquals(50.0, calDTO.getResult());
    }

    @Test
    @DisplayName("Test division when DB already has record")
    void test_DivisionWhenDBHasRecord() {
        cal.setId(1);
        cal.setResult(2.0);
        cal.setCalculation("10/5");
        List<Calculator> calList = new ArrayList<>();
        calList.add(cal);
        doReturn(calList).when(daoMock).get("10/5");
        CalculatorDTO calDTO = service.division(10, 5);

        Assertions.assertEquals(cal.getResult(), calDTO.getResult());
    }

    @Test
    @DisplayName("Test division")
    void test_DivisionWhenDBDoesNotHaveRecord() {

        List<Calculator> calList = new ArrayList<>();
        doReturn(new ArrayList<>()).when(daoMock).get("10/5");
        CalculatorDTO calDTO = service.division(10, 5);

        Assertions.assertEquals(2.0, calDTO.getResult());
    }

}
