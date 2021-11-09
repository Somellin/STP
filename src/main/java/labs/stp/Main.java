package labs.stp;


import labs.stp.fraction.Fraction;
import static labs.stp.fraction.fmath.MathFraction.*;


public class Main {
    public static void main(String[] args) {

//        //0
//        Fraction f = new Fraction();
//        System.out.println(f);
//        //1
//        Fraction fr = new Fraction(14,20);
//        //2
//        Fraction fr2 = new Fraction("23/43");
//        System.out.println(fr2);
//        //3
//        Fraction fr3 = fr.clone();
//        System.out.println(fr3);
//        //4
//        Fraction f41 = new Fraction(1,2);
//        Fraction f42 = new Fraction(-3,4);
//        Fraction f4 = add(f41,f42);
//        System.out.println(f4.getFraction());
//        //5
//        Fraction f5 = multiply(f41,f42);
//        System.out.println(f5.getFraction());
//        //6
//        Fraction f6 = subtract(f41,f42);
//        System.out.println(f6.getFraction());
//        //7
//        Fraction f7 = divide(f41,f42);
//        System.out.println(f7.getFraction());
//        //8
//        Fraction f8 = square(f41);
//        System.out.println(f8.getFraction());
//        //9
//        Fraction f9 = opposite(f41);
//        System.out.println(f9.getFraction());
//        //10
//        Fraction f10 = minus(f41);
//        System.out.println(f10.getFraction());
//        //11
//        System.out.println("larger");
//        System.out.println(larger(new Fraction("4/3"),new Fraction("9/5")));
//
//        System.out.println(f41.getNumerator());
//        System.out.println(f41.getNumeratorStr());
//        System.out.println(f41.getDenominatorStr());
//

        Fraction f = new Fraction("4/-3");
        System.out.println(f.getNumeratorStr());
        System.out.println(f.getDenominatorStr());

    }
}
