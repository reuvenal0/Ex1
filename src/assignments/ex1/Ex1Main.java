package assignments.ex1;
import java.sql.Array;
import java.util.Scanner;
import java.util.Arrays;

/** Intro2CS, Ex1 - Ex1Main.java */

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner so we can get input form the user

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

                if (!validNum1) // in case of invalid input to num1:
                {
                    // error MSG print
                    System.out.println("ERR: num1 is in the wrong format! (" + num1+ ")");

                    // and we'll go back to the beginning of the loop to try get num1 again
                }

                // in case of valid num1 input:
                else if (validNum1)
                {
                    // moving on to asking the user second number:

                    //MSG print to the user
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");

                    // getting Second number form the user: num2
                    num2 = sc.next();

                    // if the user input "quit", we need to close the program, so let's break this loop:
                    if (num2.equals("quit")) break;

                    boolean validNum2 = Ex1.isNumber(num2); // check if num2 is in the valid format
                    int num2_value = Ex1.number2Int(num2); // converting num2 to decimal base (String to Int)

                    //let's print what is the status of num2: valid and decimal value
                    System.out.println("num2= " + num2 + " is number: "+ validNum2 + " , value: " + num2_value);

                    if (!validNum2) // in case of invalid input to num2:
                    {
                        // let's restart the loop and ask again for first number, so let's stop this loop iteration and start an new loop iteration:

                        // error MSG print
                        System.out.println("ERR: num2 is in the wrong format! (" + num2+ ")");
                        continue;
                    }

                    // moving on to ask the user the desired output number base

                    System.out.println("Enter a base for output: (a number [2,16]"); //msg print to the user

                    int new_Base = sc.nextInt(); //getting base value
                    if ((new_Base  < 2) || (new_Base > 16)) // invald base value
                    {
                        //error MSG print
                        System.out.println("ERR: wrong base, should be [2,16], got (" + new_Base + ")");
                        // let's restart the loop and ask again for first number, so let's stop this loop iteration and start an new loop iteration:
                        continue;
                    }

                    // calculate the sum and product of two numbers (in decimal base):
                    int dec_sum = num1_value + num2_value;
                    int dec_multiplication = num1_value*num2_value;

                    // convert the results to the desired base:
                    String sum_result = Ex1.int2Number(dec_sum, new_Base);
                    String mul_result = Ex1.int2Number(dec_multiplication, new_Base);

                    // printing results in desired base:
                    System.out.println(num1 + " + " + num2 + " = " + sum_result);
                    System.out.println(num1 + " * " + num2 + " = " + mul_result);

                    // finally let's find the highest value we have in this iteration:

                    String [] allNumbersArr = {num1, num2, sum_result, mul_result}; // putting the numbers of the iteration in an array of Strings
                    int maxValueIndex = Ex1.maxIndex(allNumbersArr); // using the function maxIndex to find the index of highest value in out array: allNumbersArr

                    // printing the highest value result:
                    System.out.println("Max number over " + Arrays.toString(allNumbersArr) + " is: " + allNumbersArr[maxValueIndex]);
                }
            }
        }

        //out of the loop, so:
        System.out.println("quiting now...");
        //the program ends.
    }
}
