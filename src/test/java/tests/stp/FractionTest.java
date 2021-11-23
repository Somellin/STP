package tests.stp;

import labs.stp.fraction.Fraction;

import static org.junit.jupiter.api.Assertions.*;

import labs.stp.fraction.exception.FractionNullDenominatorException;
import labs.stp.fraction.exception.FractionStringException;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FractionTest {
    private Fraction fracInt;
    private Fraction fracStr;
    private Fraction fracException;

    @BeforeAll
    void init() {
        fracInt = new Fraction(3, 4);
        fracStr = new Fraction("3/4");
        fracException = new Fraction();
    }

    @Test
    void fractionNullDenominatorExceptionTest() {
        assertThrows(FractionNullDenominatorException.class, () -> {
            fracException.exceptionController(0);
        });
    }

    @Test
    void fractionStringExceptionTest() {
        assertThrows(FractionStringException.class, () -> {
            fracException.exceptionController(1);
        });
    }

    @Test
    void constructorFractionIntTest() {
        assertEquals(fracInt, new Fraction(3, 4));
    }

    @Test
    void constructorFractionStringTest() {
        assertEquals(fracStr, new Fraction(3, 4));
    }

    @Test
    void reductionTest() {
        Fraction f = new Fraction(10, 20);
        f.reduction();
        assertEquals(f, new Fraction(1, 2));
    }

    @Test
    void generalFormTest() {
        Fraction f = new Fraction(9, -3);
        f.generalForm();
        assertEquals(f, new Fraction(-9, 3));
    }

    @Test
    void getNumeratorIntTest() {
        Object expect = fracInt.getNumerator();
        assertTrue(expect instanceof Integer);
    }

    @Test
    void getNumeratorStringTest() {
        Object expect = fracInt.getNumeratorStr();
        assertTrue(expect instanceof String);
    }

    @Test
    void getDenominatorIntTest() {
        Object expect = fracInt.getDenominator();
        assertTrue(expect instanceof Integer);
    }

    @Test
    void getDenominatorStringTest() {
        Object expect = fracInt.getDenominatorStr();
        assertTrue(expect instanceof String);
    }

    @Test
    void fractionCloneTest() {
        Fraction expect = fracInt.clone();
        expect.setNumerator(5);
        assertNotEquals(expect, fracInt);
    }

}
