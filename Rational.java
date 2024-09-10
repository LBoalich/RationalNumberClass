//Imports
import java.lang.Number;
import java.math.BigInteger;

/*Rational number class extends Number and implements Comparable with two constructors */
public class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private BigInteger numerator = new BigInteger("0");
    private BigInteger denominator = new BigInteger("1");

    /** Construct a rational with default properties */
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    /** Construct a rational with specified numerator and denominator */
    public Rational(BigInteger numerator, BigInteger denominator) {
        //Get greatest common denominator
        BigInteger gcd = gcd(numerator, denominator);
        //Calculate numerator
        this.numerator = (((denominator.compareTo(BigInteger.ZERO) == -1) || (denominator.compareTo(BigInteger.ZERO) == 0)) ? new BigInteger("-1") : BigInteger.ONE).multiply(numerator.divide(gcd));
        //Calculate denominator
        this.denominator = denominator.abs().divide(gcd);
    }

    /** Find GCD of two numbers */
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        return n.gcd(d);
    }

    /** Return numerator */
    public BigInteger getNumerator() {
        return numerator;
    }

    /** Return denominator */
    public BigInteger getDenominator() {
        return denominator;
    }

    /** Add a rational number to this rational */
    public Rational add(Rational secondRational) {
        //Calculate new numerator
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
        //Calculate new denominator
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        //Return calculated rational number
        return new Rational(n, d);
    }

    /** Subtract a rational number from this rational */
    public Rational subtract(Rational secondRational) {
        //Calculate new numerator
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
        //Calculate new denominator
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        //Return calculated rational number
        return new Rational(n, d);
    }

    /** Multiply a rational number by this rational */
    public Rational multiply(Rational secondRational) {
        //Calculate new numerator
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        //Calculate new denominator
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        //Return calculated rational number
        return new Rational(n, d);
    }

    /** Divide a rational number by this rational */
    public Rational divide(Rational secondRational) {
        //Calculate new numerator
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        //Calculate new denominator
        BigInteger d = denominator.multiply(secondRational.numerator);
        //Return calculated rational number
        return new Rational(n, d);
    }

    @Override //Override the toString method in the Object class
    public String toString() {
        if (denominator == BigInteger.ONE)  //Omit denominator if 1
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    @Override // Override the equals method in the Object class
    public boolean equals(Object other) {
        if ((this.subtract((Rational)(other))).getNumerator() == BigInteger.ZERO) //Return true if subtraction equals 0
            return true;
        else
            return false;
    }

    @Override // Implement the abstract intValue method in Number
    public int intValue() {
        return (int)doubleValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float)doubleValue();
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long)doubleValue();
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        if ((this.subtract(o).getNumerator()).intValue() > 0) //this is larger than o
            return 1;
        else if ((this.subtract(o).getNumerator()).intValue() < 0) //this is less than o
            return -1;
        else //this equals o
            return 0;
    }
}
