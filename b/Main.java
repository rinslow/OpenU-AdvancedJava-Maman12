package b;

public class Main {
    public static void main(String[] args) {

        boolean isTest = false;
        Rational r1 = null, r2 = null;
        Rational zero = new Rational(0, 1);


        if (isTest) {
            r1 = new Rational("2/3");
            r2 = new Rational("2/12");
        } else {
            boolean isInputOk = false;
            while (!isInputOk) {
                try {
                    System.out.println("Enter 2 rationals in the form of a/b:");
                    String input = System.console().readLine();
                    r1 = new Rational(input);
                    System.out.printf("Got %s (%s), enter another one:%n", r1, r1.reduce());
                    input = System.console().readLine();
                    r2 = new Rational(input);
                    System.out.printf("Got %s (%s)%n", r2, r2.reduce());
                    isInputOk = true;
                } catch (Exception e) {
                    System.out.println("Invalid input, try again");
                }
            }
        }

        r1 = r1.reduce();
        r2 = r2.reduce();

        System.out.println(String.format("%s > %s: %b", r1, r2, r1.greaterThan(r2)));
        System.out.println(String.format("%s = %s: %b", r1, r2, r1.equals(r2)));
        System.out.println(String.format("%s + %s = %s", r1, r2, r1.plus(r2).reduce()));
        System.out.println(String.format("%s - %s = %s", r1, r2, r1.minus(r2).reduce()));
        System.out.println(String.format("%s - %s = %s", r2, r1, r2.minus(r1).reduce()));
        System.out.println(String.format("%s * %s = %s", r1, r2, r1.multiply(r2).reduce()));
        if (!r2.equals(zero)) {
            System.out.println(String.format("%s / %s = %s", r1, r2, r1.divide(r2).reduce()));
        } else {
            System.out.println(String.format("%s / %s = undefined", r1, r2));
        }
        if (!r1.equals(zero)) {
            System.out.println(String.format("%s / %s = %s", r2, r1, r2.divide(r1).reduce()));
        } else {
            System.out.println(String.format("%s / %s = undefined", r2, r1));
        }

    }
}
