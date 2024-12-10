package assignments.ex1;

import static java.lang.Character.toUpperCase;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
        /**
         * Convert the given number (num) to a decimal representation (as int).
         * If the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return The number in decimal base - in an int variable.
         */
        public static int number2Int(String num) {
            // Set default as -1, in case of invalid string num
            int ans = -1;

            //Make sure number is in the valid format
            if (isNumber(num))
            {
                ans = 0; // number is valid, so min value is zero (natural numbers)
                int value, power; // value: the digit value, power: power value we need to multiply the digit
                char temp_char; // each char in the string is a digit

                // First let's see if we are receiving a valid number in decimal base, without 'b'
                // We will use the function "How_Many_Times_Char_In_Str": the function receive a String + Char,and Calculates (with recursion) how many times the char appears in the String (we preform the function in a lecture with Assaf)
                if (How_Many_Times_Char_In_Str(num, 'b') == 0)
                {
                    // num is only decimal digit (0-9).
                    // let's manually convert the String to Int, via a loop:
                    // We will go over the String "reverse order" (form lower to higher digit), each time multiply the digit by its position: The position is in the power of ten - because we are in decimal base.
                    for (int i = 0; i < num.length(); i++)
                    {
                        temp_char = num.charAt(num.length() - i -1); // Extract the right digit each time.
                        // We will convert the number from char to int - using the function "getNumericValue":
                        // which use Unicode table to convert a char to numeric value - then the function interprets the value so that it matches the representation of chars in the bases we know (in hexadecimal for exemple).
                        value = Character.getNumericValue(temp_char);
                        power = (int) Math.pow (10,i); // Calculating the power of each digit in a number - 10 power the digit location.

                        ans += value*power; // Adding the sum of the digit.
                    }
                    return ans; // After we have finished converting the Sting to int - we will return the number.
                }

                // Number is in the valid format, With 'b' Separates the number from the base.
                // let's split it using split function and save the number and base into two Array members:
                String [] str_Numbers = num.split("b");
                //str_Numbers[1] is the original base, after the split we did - and contains exactly one char (valid num definition)
                temp_char = str_Numbers[1].charAt(0);
                // let's get the original base into a valid int - using getNumericValue again:
                int old_Base = Character.getNumericValue(temp_char);

                // let's manually convert the String to Int, via a loop:
                for (int i = 0; i <  str_Numbers[0].length(); i++)
                {
                    temp_char = str_Numbers[0].charAt(str_Numbers[0].length() -i-1); // Extract the right digit each time.
                    value = Character.getNumericValue(temp_char); //get the char in to int value - using 'getNumericValue'.
                    power = (int) Math.pow (old_Base,i); // Calculating the power of each digit in a number - the original base**power the digit location.


                    ans += power*value; // adding the result into the sum;
                }
            }
            return ans; // After we have finished converting the Sting to int - we will return the number.
        }


        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            // an empty String isn't valid:
            if (a == null || a.isEmpty()) return false;

            // first let's see how much 'b' chars we got in the String:
            int howb = How_Many_Times_Char_In_Str(a, 'b');

            // if there is no 'b' but the string is only 0-9 digit (without invalid chars) so we are in base 10 and it's all good:
            // let's use matches function on the String, with regex that check from the beginning of the string to it's end, that only 0-9 digit appear (regardless of the number of times the digit appears).
            if ((howb == 0) && (a.matches("^[0-9]+$"))) return true; // valid decimal number!


            // The second situation is that we have a 'b' that separates the number from the base, we will make sure that the String contains only: 0-9 digits, 'b' lower case, "A-G" upper case.
            // Any other chars invalidates the string (e.g: space , G+ latter, or other special character)
            // aging we will use matches function with regex:
            if (!a.matches("^[bA-G0-9]+$")) return false; //we got an invalid char

            // more then one 'b' isn't valid:
            if (howb < 1) return false;

            // now we have a String with obe 'b', let's split the number form the base, and save them into Separate cells in an array
            String [] str_Numbers = a.split("b");
            // str_numbers [0] - the number itself.
            // str_number [1] - the original base.

            // if we were unable to separate into two different strings, it means that the string isn't valid:
            if (str_Numbers.length != 2) return false;
            //if the number is empty we got an invalid String:
            if (str_Numbers[0].isEmpty()) return false;

            // the original base is represented by only one character (in base 17)
            if (str_Numbers[1].length() != 1) return false;

            char base = str_Numbers[1].charAt(0); // extracting the original base char.
            int base_value = Character.getNumericValue(base); // converting the original base to int value, using "getNumericValue" function aging (used in the previous function)

            if (base_value < 2 || base_value > 16) return false; // valid base is 2 to 16

            // now we need to make sure that all the digits in the number contain only digits that are in the original base - otherwise the number is invalid:
            for (int i = 0; i < str_Numbers[0].length(); i++)
            {
                if(Character.getNumericValue(str_Numbers[0].charAt(i)) >= base_value) return false;
            }

            return true; // valid number!
        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            String ans = "-1"; // for invalid number or base

            // first let's make sure we get a number and base within the valid range:
            if ((num >= 0) && (base > 1) && (base < 17))
            {
                // we got valid number and base, let's reboot String ans as empty:
                ans = "";

                // to convert the number to a string, we will use the function "toString" which convert a number to a string according to the specified base.
                // We will use this function and not perform manual division (as we multiplied with the function "number2int") - Ilan confirmed me to use this function if I know to use it.
                // "toString" receives an number (int decimal base) and a base (also represented in decimal base):
                ans = Integer.toString(num, base).toUpperCase();

                // in all bases except decimal, we will add the base (represented in 17 base: so we have 'G' digit) after the number itself with 'b' serpenting:
                if (base != 10)
                {
                    // We will convert the number to a char using "forDigit" function, which is essentially the opposite of the "getNumericValue" function we used before.
                    // also, we need to convert the letters to Upper Case if necessary.
                    ans += "b" + toUpperCase(Character.forDigit(base,17));
                }
            }
            return ans;
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            // null is invalid number, so it can't be equal to any number (just like "3b2" isn't equal to "-1" any number ):
            if (n1 == null || n2 == null) return false;

            // convert the numbers to decimal value (int) and then check if the value is equal (format inspection is included)
            if (number2Int(n1) == number2Int(n2)) return true;

            // in case of not equal value or invalid num format - return false:
            return false;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int ans = 0; // first index is the bigger until a higher number than the number at index 0 is found

            // we will loop through all the numbers in the array
            for (int i = 1; i < arr.length; i++)
            {
                if (number2Int(arr[ans]) < number2Int(arr[i])) // A higher number than the highest number we have had so far
                {
                    ans = i; // let's save the index of the higher number
                }
            }
            return ans; // returns the index of the higher number
        }

        /**
         * This static function sums how many times a certain char appears in a string - Using recursion.
         * We learned to do this function in a lecture with Assaf.
         * @param str a String.
         * @param c a char.
         * @return the number of times the char appears in the String.
         */
        public static int How_Many_Times_Char_In_Str (String str, char c)
        {
            if (str == null || str.isEmpty()) return 0; // We have no char left to check in the string.

            // the first char in the String Matches the desired char: adding 1 to the sum, and moving to the next char.
            if (str.charAt(0) == c) return (How_Many_Times_Char_In_Str(str.substring(1), c) + 1);

            // the char isn't is the char we are searching for, but let's continue checking the next char's in the string
            return (How_Many_Times_Char_In_Str(str.substring(1), c));
        }
}
