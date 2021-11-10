package tests.stp;

import labs.stp.fraction.Fraction;
import static org.junit.jupiter.api.Assertions.*;

import labs.stp.fraction.exception.FractionNullDenominatorException;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FractionTest {


    @BeforeAll
    void init(){
        System.out.println("Before all:");
    }

    @Test
    void constructorFractionIntTest(){
        System.out.println("test 1:" + this);
        Fraction f = new Fraction(4,3);
        assertEquals(f, new Fraction(4, 3));
    }

    @Test
    void constructorFractionStringTest(){
        System.out.println("test 1:" + this);
        Fraction f = new Fraction("4/3");
        assertEquals(f, new Fraction(4, 3));
    }



}
