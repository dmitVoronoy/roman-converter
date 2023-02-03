package com.example.romanconverter;

import com.example.romanconverter.controller.RomanConverterController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class RomanConverterApplicationTests {

    @Autowired
    private RomanConverterController controller;

    @Test
    void numbersTest() {
        String ten = controller.convert(10);
        assertThat(ten).isEqualTo("X");

        String three = controller.convert(3);
        assertThat(three).isEqualTo("III");

        String big = controller.convert(1564);
        assertThat(big).isEqualTo("MDLXIV");
    }

    @Test
    void illegalInputTest() {
        assertThatThrownBy(() -> controller.convert(-5)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> controller.convert(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> controller.convert(1000001)).isInstanceOf(IllegalArgumentException.class);
    }

}
