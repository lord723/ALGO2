package aed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CoberturaTests {
    Cobertura cobertura = new Cobertura();

    @Test
    void testFizzBuzz() {
        assertEquals("Fizz",cobertura.fizzBuzz(3));
        assertEquals("Buzz",cobertura.fizzBuzz(10));
        assertEquals("FizzBuzz",cobertura.fizzBuzz(15));
        assertEquals("49",cobertura.fizzBuzz(49));
        assertEquals("Fizz",cobertura.fizzBuzz(9));
    }

    @Test
    void testNumeroCombinatorio() {
        assertEquals(1,cobertura.numeroCombinatorio(0,0));
    }

    @Test
    void testRepeticionesConsecutivas() {
        assertEquals(3,cobertura.repeticionesConsecutivas(new int[]{1,1,1,3,4,1,1,5,8}));
        assertEquals(3,cobertura.repeticionesConsecutivas(new int[]{0,3,4,1,1,1,5,8}));
    }
}
