package assignments.ex1;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit"))
            {
                boolean validNum1 = Ex1.isNumber(num1);
                int num1_value = Ex1.number2Int(num1);
                System.out.println("num1= " + num1 + " is number: "+ validNum1 + " , value: " + num1_value);
                if (validNum1) {
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = sc.next();

                    if (num2.equals("quit")) break;

                    boolean validNum2 = Ex1.isNumber(num2);
                    int num2_value = Ex1.number2Int(num2);

                    if (!validNum2) {
                        System.out.println("ERR: num2 is in the wrong format! " + num2);
                        continue;
                    }

                    System.out.println("num2= " + num2 + " is number: "+ validNum2 + " , value: " + num2_value);

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
                    System.out.println("Max number over " + num1 + " " + num2 + " " + sum_result + " " +  mul_result + " is: " + allNumbersArr[maxValueIndex]);
                }
            }
        }
        System.out.println("quiting now...");
        //the program ends...
    }
}
