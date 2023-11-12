package org.example.q1.Numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {

    private Rational rational;
    private Rational rational1;

    @BeforeEach
    void setup(){
        rational = new Rational(2,3);
        rational1 = new Rational(1,3);
    }

    @Test
    void Testadd() {
        Rational add = rational.add(rational1);
        assertEquals(new Rational(1, 1), add);
    }

    @Test
    void Testsub() {
        Rational sub = rational.sub(rational1);
        assertEquals(new Rational(1, 3), sub);
    }

    @Test
    void Testmul() {
        Rational mul = rational.mul(rational1);
        assertEquals(new Rational(2, 9), mul);
    }

    @Test
    void TestRegularDiv() {
        Rational div = rational.div(rational1);
        assertEquals(new Rational(2, 1), div);

    }

    @Test
    void TestDivByZero() {
        Rational rational = new Rational(8, 12);
        Rational rational1 = new Rational(0, 9);
        assertThrows(ArithmeticException.class, () -> {
            rational.div(rational1);
        });
    }

    @Test
    void TesttoFloatingPoint() {
        Rational rational = new Rational(8, 12);
        double floatingPoint = rational.toFloatingPoint();
        assertEquals(0.666666666666, floatingPoint, 0.00000000001);

    }


    @Test
    void testToMixedNumber() {
        Rational rational2 = new Rational(7, 2);
        String mixedNumber = rational2.toMixedNumber();
        assertEquals("1/2+3", mixedNumber);
    }
}