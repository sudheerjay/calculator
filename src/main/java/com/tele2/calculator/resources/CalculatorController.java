package com.tele2.calculator.resources;

import com.tele2.calculator.model.CalculatorDTO;
import com.tele2.calculator.service.CalculatorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService service;

    @GetMapping("/add/{a}/{b}")
    public ResponseEntity<CalculatorDTO> add(@PathVariable("a") int a, @PathVariable("b") int b){
        CalculatorDTO responseDTO = service.addition(a,b);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/subtract/{a}/{b}")
    public ResponseEntity<CalculatorDTO> subtraction(@PathVariable("a") int a, @PathVariable("b") int b){
        CalculatorDTO responseDTO =  service.subtraction(a,b);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/multiply/{a}/{b}")
    public ResponseEntity<CalculatorDTO> multiplication(@PathVariable("a") int a, @PathVariable("b") int b){
        CalculatorDTO responseDTO =  service.multiplication(a,b);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/divide/{a}/{b}")
    public ResponseEntity<CalculatorDTO> division(@PathVariable("a") int a, @PathVariable("b") int b){
        CalculatorDTO responseDTO = service.division(a,b);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CalculatorDTO>> getAll(){
        List<CalculatorDTO>  responseList = service.getAllCalculations();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
