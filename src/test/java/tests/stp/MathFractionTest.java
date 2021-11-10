package tests.stp;

import static org.junit.jupiter.api.Assertions.*;
import static labs.stp.fraction.fmath.MathFraction.*;

import labs.stp.fraction.Fraction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathFractionTest {

    Fraction fractionOne;
    Fraction fractionTwo;

    @BeforeAll
    void init() {
        fractionOne = new Fraction(4, 6);
        fractionTwo = new Fraction(6, 11);
    }

    @Test
    void addFractionTest() {
        Fraction expect = add(fractionOne, fractionTwo);
        assertEquals(expect,new Fraction(40,33));
    }

    @Test
    void multiplyFractionTest() {
        Fraction expect = multiply(fractionOne, fractionTwo);
        assertEquals(new Fraction(4,11),expect);
    }

    @Test
    void subtractFractionTest() {
        Fraction expect = subtract(fractionOne, fractionTwo);
        assertEquals(new Fraction(4,33),expect);
    }

    @Test
    void divideFractionTest() {
        Fraction expect = divide(fractionOne, fractionTwo);
        assertEquals(new Fraction(11,9),expect);
    }

    @Test
    void squareFractionTest() {
        Fraction expect = square(fractionOne);
        assertEquals(new Fraction(4,9),expect);
    }

    @Test
    void oppositeFractionTest() {
        Fraction expect = opposite(fractionOne);
        assertEquals(new Fraction(6,4),expect);
    }

    @Test
    void minusFractionTest() {
        Fraction expect = minus(fractionOne);
        assertEquals(new Fraction(-2,3),expect);
    }

    @Test
    void largerFractionTest() {
        Boolean expect = larger(fractionOne,fractionTwo);
        assertEquals(true,expect);
    }
}
