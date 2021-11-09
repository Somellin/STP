package labs.stp.fraction.fmath;

public final class GCD {

    /**
     * НОД - наибольшее число, которое является делителем одновременно для чисел a и b.
     * Реализация (Алгоритм Евклида):
     *
     * @param a целое число
     * @param b целое число
     * @return наибольший общий делитель a и b
     */
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * НОК - наименьшее число, которое делится на a и b без остатка.
     *
     * @param a целое число
     * @param b целое число
     * @return наименьшее общее кратное
     */
    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
