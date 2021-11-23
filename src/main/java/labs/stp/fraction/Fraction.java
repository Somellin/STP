package labs.stp.fraction;

import labs.stp.fraction.exception.FractionNullDenominatorException;
import labs.stp.fraction.exception.FractionStringException;
import labs.stp.fraction.fmath.GCD;

import java.util.Objects;

public class Fraction implements Cloneable {

    private int numerator;
    private int denominator;

    /**
     * Стандартный конструктор без параметров
     */
    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * Конструктор с параметрами в виде числовых значений
     *
     * @param numerator   - числитель
     * @param denominator - знаменатель
     */
    public Fraction(int numerator, int denominator) {
        try {
            this.numerator = numerator;
            this.denominator = denominator;
            generalForm();
            if (this.denominator == 0)
                throw new FractionNullDenominatorException();
        } catch (FractionNullDenominatorException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Конструктор для передачи значений дроби в виде строки
     *
     * @param fraction - Подаем на вход дробь в виде строки
     */
    public Fraction(String fraction) {
        int num = 0;
        int denom = 0;
        int k = 0;
        int negative = 0;
        try {
            for (Character c : fraction.toCharArray()) {
                if (c == '/') {
                    k = 1;
                    continue;
                }
                if (c == '-') {
                    negative = 1;
                    continue;
                }
                if (!Character.isDigit(c))
                    exceptionController(1);
//                    throw new FractionStringException();
                if (k == 0) {
                    num += Integer.parseInt(String.valueOf(c));
                    num *= 10;
                }
                if (k == 1) {
                    denom += Integer.parseInt(String.valueOf(c));
                    denom *= 10;
                }
            }
            num /= 10;
            denom /= 10;

            if (negative == 1)
                this.numerator = -num;
            else this.numerator = num;
            this.denominator = denom;

            if (this.denominator == 0)
                exceptionController(0);
//                throw new FractionNullDenominatorException();

        } catch (FractionNullDenominatorException | FractionStringException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * Метод сокращения дроби чрез нахождение
     * наибольшего общего делителя
     */
    public void reduction() {
        int gcd;
        gcd = GCD.gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        generalForm();
    }

    /**
     * Приведение дроби к общей форме вывода:
     * если дробь отрицательная то отрицательным числом становится числитель
     */
    public void generalForm() {
        if (denominator < 0) {
            denominator *= -1;
            numerator *= -1;
        }
    }

    /**
     * Получение числителя в виде числа
     *
     * @return числовое значение числителя
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Получение знаменателя в виде числа
     *
     * @return числовое значение знаменателя
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Получение числителя в виде строки
     *
     * @return строчное значение числителя
     */
    public String getNumeratorStr() {
        return String.valueOf(numerator);
    }

    /**
     * Получение знаменателя в виде строки
     *
     * @return строчное значение знаменателя
     */
    public String getDenominatorStr() {
        return String.valueOf(denominator);
    }

    /**
     * Получение сокращенной дроби в виде n/d
     *
     * @return Получение дроби в виде строки
     */
    public String getFraction() {
        this.reduction();
        return numerator + "/" + denominator;
    }

    /**
     * Клонирование дроби
     *
     * @return возвращает новый объект дроби с прежними значениями
     */
    @Override
    public Fraction clone() {
        try {
            return (Fraction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * Получение дроби в виде строки без сокращения
     *
     * @return дробь в формате строки
     */
    @Override
    public String toString() {
        generalForm();
        return numerator + "/" + denominator;
    }

    /**
     * Сравнивает саму простую дробь this и frac.
     *
     * @param frac - простая дробь
     * @return - Возвращает
     * значение True, если this и frac - тождественные простые
     * дроби, и значение False - в противном случае.
     */
    @Override
    public boolean equals(Object frac) {
        if (this == frac) return true;
        if (frac == null || getClass() != frac.getClass()) return false;
        Fraction fraction = (Fraction) frac;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    /**
     * Создает хэш код
     *
     * @return числовое значение
     */
    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    public String exceptionController(int k) throws FractionNullDenominatorException, FractionStringException {
        if (k == 0)
            throw new FractionNullDenominatorException();
        else throw new FractionStringException();
    }

}
