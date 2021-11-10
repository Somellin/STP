package labs.stp.fraction.fmath;

import labs.stp.fraction.Fraction;

public final class MathFraction {

    /**
     * Создаёт и возвращает простую дробь (тип TFrac),
     * полученную сложением самой дроби
     * this = a1/b1 с d=a2/b2:
     * ((a1/b1)+(a2/b2)=(a1*b2 + a2*b1)/( b1* b2)).
     *
     * @param f1 - первая дробь
     * @param f2 - вторая дробь
     * @return объект дроби возвращает результат сложения
     */
    public static Fraction add(Fraction f1, Fraction f2) {
        return new Fraction(
                (f1.getNumerator() * f2.getDenominator()) +
                        (f2.getNumerator() * f1.getDenominator()),
                f1.getDenominator() * f2.getDenominator());
    }

    /**
     * Создаёт простую дробь, полученную
     * умножением самой дроби this = a1/b1 на d = a2/b2
     * ((a1/b1)*(a2/b2)=(a1* a2)/( b1* b2)).
     *
     * @param f1 объект простой дроби
     * @param f2 объект простой дроби
     * @return объект дроби возвращает результат умножения
     */
    public static Fraction multiply(Fraction f1, Fraction f2) {
        return new Fraction(
                f1.getNumerator() * f2.getNumerator(),
                f1.getDenominator() * f2.getDenominator());
    }

    /**
     * Создаёт и возвращает простую дробь (тип TFrac),
     * полученную вычитанием d = a2/b2 из самой дроби this
     * = a1/b1: ((a1/b1)-(a2/b2)=(a1* b2-a2*b1)/(b1*b2)).
     * Например:
     * q = (1/2), d = (1/2)
     * q.Вычесть(d) = (0/1).
     *
     * @param f1 объект простой дроби
     * @param f2 объект простой дроби
     * @return объект дроби возвращает результат вычитания
     */
    public static Fraction subtract(Fraction f1, Fraction f2) {
        return new Fraction(
                (f1.getNumerator() * f2.getDenominator()) -
                        (f2.getNumerator() * f1.getDenominator()),
                f1.getDenominator() * f2.getDenominator());
    }

    /**
     * Создаёт и возвращает простую дробь (тип TFrac),
     * полученное делением самой дроби this = a1/b1 на дробь
     * d = a2/b2: ((a1/b1)/(a2/b2)=(a1* b2)/(a2*b1)).
     *
     * @param f1 объект простой дроби
     * @param f2 объект простой дроби
     * @return объект дроби возвращает результат деления
     */
    public static Fraction divide(Fraction f1, Fraction f2) {
        return new Fraction(
                f1.getNumerator() * f2.getDenominator(),
                f2.getNumerator() * f1.getDenominator());
    }

    /**
     * Создаёт и возвращает простую дробь (тип TFrac),
     * полученную умножением самой дроби this на себя:
     * ((a/b)*(a/b)=(a* a)/(b* b)).
     *
     * @param f1 объект простой дроби
     * @return объект дроби возвращает результат квадрата дроби
     */
    public static Fraction square(Fraction f1) {
        return new Fraction(
                f1.getNumerator() * f1.getNumerator(),
                f1.getDenominator() * f1.getDenominator());
    }

    /**
     * Создаёт и возвращает простую дробь (тип TFrac),
     * полученное делением единицы на саму дробь this:
     * 1/(a/b) = b/a.
     *
     * @param f1 - объект простой дроби
     * @return объект дроби возвращает обратную дробь
     */
    public static Fraction opposite(Fraction f1) {
        return new Fraction(f1.getDenominator(), f1.getNumerator());
    }

    /**
     * Создаёт простую дробь, являющуюся разностью
     * простых дробей z и this, где z - простая дробь (0/1)
     *
     * @param f1 - простая дробь
     * @return - Простая дробь
     */
    public static Fraction minus(Fraction f1) {
        Fraction z = new Fraction(0, 1);
        return subtract(z, f1);
    }

    /**
     * Сравнивает саму простую дробь f1 и f2.
     *
     * @param f1 - простая дробь
     * @param f2 - простая дробь
     * @return - Возвращает значение True, если f1 > f2,
     * значение False - в противном случае.
     */
    public static boolean larger(Fraction f1, Fraction f2) {
        int lcm = GCD.lcm(f1.getDenominator(), f2.getDenominator());
        return lcm / f1.getDenominator() > lcm / f2.getDenominator();
    }
}
