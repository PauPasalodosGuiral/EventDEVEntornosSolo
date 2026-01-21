package com.azahartech.eventdev.calc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraPreciosTest {

    @Test
    void verificaCalculosCorrectos() {
        CalculadoraPrecios cal = new CalculadoraPrecios();

        assertEquals(217.8, cal.calculadoraPrecioTotal(100, 2, 1), 0.01);

        assertEquals(181.5, cal.calculadoraPrecioTotal(100, 1, 2), 0.01);
    }
}

