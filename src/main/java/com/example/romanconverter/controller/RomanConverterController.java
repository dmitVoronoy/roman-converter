package com.example.romanconverter.controller;

import com.example.romanconverter.service.RomanConverterService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanConverterController {

    private final RomanConverterService service;

    public RomanConverterController(RomanConverterService service) {
        this.service = service;
    }

    @GetMapping("/convert")
    public String convert(@RequestParam int number) {
        return service.convert(number);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleError(IllegalArgumentException e) {
        return e.getMessage();
    }
}
