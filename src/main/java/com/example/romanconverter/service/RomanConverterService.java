package com.example.romanconverter.service;

import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class RomanConverterService {
    private static final TreeMap<Integer, String> romanSymbols = new TreeMap<>();
    static {
        romanSymbols.put(1000, "M");
        romanSymbols.put(900, "CM");
        romanSymbols.put(500, "D");
        romanSymbols.put(400, "CD");
        romanSymbols.put(100, "C");
        romanSymbols.put(90, "XC");
        romanSymbols.put(50, "L");
        romanSymbols.put(40, "XL");
        romanSymbols.put(10, "X");
        romanSymbols.put(9, "IX");
        romanSymbols.put(5, "V");
        romanSymbols.put(4, "IV");
        romanSymbols.put(1, "I");

    }

    public String convert(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Roman numerals cannot be zero or negative");
        }
        if (number > 1000000) {
            throw new IllegalArgumentException("Server is not set up to process numbers higher than 1000000");
        }
        return convertInternal(number);
    }

    private String convertInternal(int number) {
        int l = romanSymbols.floorKey(number);
        if (number == l) {
            return romanSymbols.get(number);
        }
        return romanSymbols.get(l) + convertInternal(number - l);
    }
}
