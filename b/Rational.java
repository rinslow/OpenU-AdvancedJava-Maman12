package b;

public class Rational {
    private final int numerator; // mone
    private final int denominator; // mehane

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational(String rational) {
        // if it's a number, no need to use /1
        if (!rational.contains("/")) {
            try {
                this.numerator = Integer.parseInt(rational);
                this.denominator = 1;
                return;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid rational format");
            }
        }

        String[] parts = rational.split("/");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid rational format");
        }

        try {
            this.numerator = Integer.parseInt(parts[0]);
            this.denominator = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid rational format");
        }
    }

    public boolean greaterThan(Rational other) {
        int a = this.numerator;
        int b = this.denominator;
        int c = other.getNumerator();
        int d = other.getDenominator();;

        return a * d > b * c;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass() == this.getClass()) {
            Rational other = (Rational) obj;
            int a = this.numerator;
            int b = this.denominator;
            int c = other.getNumerator();
            int d = other.getDenominator();;
            return a * d == b * c;
        }

        if (obj.getClass() == Integer.class) {
            int a = this.numerator;
            int b = this.denominator;
            int c = (int) obj;
            int d = 1;
            return a * d == b * c;
        }

        return false;
    }

    public Rational plus(Rational other) {
        int a = this.numerator;
        int b = this.denominator;
        int c = other.getNumerator();
        int d = other.getDenominator();
        return new Rational(a * d + b * c, b * d);
    }

    public Rational minus(Rational other) {
        Rational minusOther = new Rational(-1, 1).multiply(other);
        return this.plus(minusOther);
    }

    public Rational multiply(Rational other) {
        int a = this.numerator;
        int b = this.denominator;
        int c = other.getNumerator();
        int d = other.getDenominator();;
        return new Rational(a * c, b * d);
    }

    public Rational divide(Rational other) {
        int a = this.numerator;
        int b = this.denominator;
        int c = other.getNumerator();
        int d = other.getDenominator();;

        if (c == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return new Rational(a * d, b * c);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        if (denominator == 1) {
            return String.format("%d", numerator);
        }

        // -1/2 is nicer on the eyes than 1/-2
        if (denominator < 0 && numerator > 0) {
            return String.format("%d/%d", -numerator, -denominator);
        }

        return String.format("%d/%d", numerator, denominator);
    }

    public Rational reduce() {
        int a = this.numerator;
        int b = this.denominator;
        int gcd = gcd(a, b);
        return new Rational(a / gcd, b / gcd);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
