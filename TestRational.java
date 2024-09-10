/*
 * Name: Rational Number Class
 * Author: Leah Boalich
 * Date: September 9, 2024
 * Assignment: Module 3 Chapter 13 Exercise 15
 * Description: This program creates a Rational Number Class that extends the abstract built in Number class and implements the Comparable interface.  It then tests the class by asking the user for two rational numbers and calling various methods to display.
 */

//Imports
import java.math.BigInteger;
import java.util.Scanner;

/*Test the Rational Class */
public class TestRational {
    //Main Module
    public static void main(String[] args) {
        //Prompt user for first rational number
        System.out.print("Enter the first rational number: ");
        //Create the input scanner
        Scanner input = new Scanner(System.in);
        //Store first rational number
        BigInteger r1Numerator = input.nextBigInteger();
        BigInteger r1Denomenator = input.nextBigInteger();
        Rational r1 = new Rational(r1Numerator, r1Denomenator);
        input.nextLine();
        //Prompt user for second rational number
        System.out.print("Enter the second rational number: ");
        //
        BigInteger r2Numerator = input.nextBigInteger();
        BigInteger r2Denomenator = input.nextBigInteger();
        Rational r2 = new Rational(r2Numerator, r2Denomenator);
        input.nextLine();
        //Display r1 plus r2
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        //Display r1 minus r2
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        //Display r1 times r2
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        //Display r1 divided by r2
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        //Display the float value of r2
        System.out.printf(r2 + " is %.19f", r2.floatValue());
        System.out.println();
        //Close input
        input.close();
    }
}
