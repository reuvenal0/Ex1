package assignments.ex1;
import java.sql.Array;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = "", num2="", quit = "quit";

        //while the user didn't input "quit" - the program keeps on running, and asking user to input number
        while (!num1.equals(quit) && !num2.equals(quit))
        {
            // print MSG for the user
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");

            // getting First number form the user: num1
            num1 = sc.next();
            if (!num1.equals("quit"))
            {
                boolean validNum1 = Ex1.isNumber(num1); // check if num1 is in the valid format
                int num1_value = Ex1.number2Int(num1); // converting num1 to decimal base (String to Int)

                //let's print what is the status of num1: valid and decimal value
                System.out.println("num1= " + num1 + " is number: "+ validNum1 + " , value: " + num1_value);

                // in case of invalid input:
                if (!validNum1)
                {
                    System.out.println("ERR: num1 is in the wrong format! (" + num1+ ")");
                }

                // in case of valid num1 input:
                else if (validNum1)
                {
                    //msg print to the user
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");

                    // getting Second number form the user: num2
                    num2 = sc.next();

                    // if the user input "quit", let's restart and ask again for first number,
                    // so let's break this loop iteration:
                    if (num2.equals("quit")) break;

                    boolean validNum2 = Ex1.isNumber(num2); // check if num2 is in the valid format
                    int num2_value = Ex1.number2Int(num2); // converting num2 to decimal base (String to Int)


                    System.out.println("num2= " + num2 + " is number: "+ validNum2 + " , value: " + num2_value);

                    if (!validNum2) {
                        System.out.println("ERR: num2 is in the wrong format! (" + num2+ ")");
                        continue;
                    }

                    System.out.println("Enter a base for output: (a number [2,16]");
                    int new_Base = sc.nextInt();
                    if ((new_Base  < 2) || (new_Base > 16))
                    {
                        System.out.println("ERR: wrong base, should be [2,16], got (" + new_Base + ")");
                        continue;
                    }

                    int dec_sum = num1_value + num2_value;
                    int dec_multiplication = num1_value*num2_value;

                    String sum_result = Ex1.int2Number(dec_sum, new_Base);
                    String mul_result = Ex1.int2Number(dec_multiplication, new_Base);

                    System.out.println(num1 + " + " + num2 + " = " + sum_result);
                    System.out.println(num1 + " * " + num2 + " = " + mul_result);

                    String [] allNumbersArr = {num1, num2, sum_result, mul_result};
                    int maxValueIndex = Ex1.maxIndex(allNumbersArr);
                    System.out.println("Max number over " + Arrays.toString(allNumbersArr) + " is: " + allNumbersArr[maxValueIndex]);
                }
                else
            }
        }
        System.out.println("quiting now...");
        //the program ends...
    }
}
