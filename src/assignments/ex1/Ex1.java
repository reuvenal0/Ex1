package assignments.ex1;
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
         * @return
         */

        public static int number2Int(String num) {
            // Set default as -1, in case of invalid string num
            int ans = -1;

            if (isNumber(num))
            {
                ans = 0;
                int value, power;
                char temp_char;
                //להוריד רווחים מההתחלה והסוף!!!

                // First let's see if we are reciving a valid number in decmal base, witout 'b'
                if (How_Many_Times_Char_In_Str(num, 'b') == 0)
                {
                    for (int i = 0; i < num.length(); i++)
                    {
                        temp_char = num.charAt(num.length() - i -1);
                        value = Character.getNumericValue(temp_char);
                        power = (int) Math.pow (10,i);

                        ans += value*power;
                    }
                    return ans;
                }

                // Number is in the valid format, let's split it:
                String [] str_Numbers = num.split("b");
                // get the old base into a valid int
                // getNumericValue conver the char to int, encloding when the vualue is by laater (base 16)
                temp_char = str_Numbers[1].charAt(0);
                int old_Base = Character.getNumericValue(temp_char);

                for (int i = 0; i <  str_Numbers[0].length(); i++)
                {
                    temp_char = str_Numbers[0].charAt(str_Numbers[0].length() -i-1);
                    value = Character.getNumericValue(temp_char);
                    power = (int) Math.pow (old_Base,i);

                    ans += power*value;
                }
            }
            return ans;
        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            //string a == null is not valid:
            if (a.isEmpty()) return false;

            // first let's see if we got a 'b' char in String:
            int howb = How_Many_Times_Char_In_Str(a, 'b');

            // if there is no 'b' but the string is only  0-9 digit (without invalid chars) so we are in base 10 and it's all got
            if ((howb == 0) && (a.matches("^[0-9]+$"))) return true;

            // if we got an invalid char - let's use regular expression (regex):
            if (!a.matches("^[bA-G0-9]+$")) return false;

            // more then one 'b' is not good:
            if (howb < 1) return false;

            // split the two numbers:
            String [] str_Numbers = a.split("b");
            //if the number is empty
            if (str_Numbers[0].isEmpty()) return false;

            if (str_Numbers[1].length() != 1) return false;

            char base = str_Numbers[1].charAt(0);
            int base_value = Character.getNumericValue(base);
            if (base_value < 2 || base_value > 16) return false;

            for (int i = 0; i < str_Numbers[0].length(); i++)
            {
                if(Character.getNumericValue(str_Numbers[0].charAt(i)) >= base_value) return false;
            }
            return true;
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
            // add your code here
            // נקבל מספר INT בבסיס עשרוני (רגיל), ובסיס מבוקש
            // נחזיר את ערך המספר בבסיס המבוקש.
            // נשתמש בtoString

            String ans = "";
            if ((num >= 0) && (base > 1) && (base < 17))
            {
                ans = Integer.toString(num, base);
                ans += "b" + Integer.toString(num, 16);
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
            if (n1.length() != n2.length()) return false;
            for (int i =0; i <n1.length(); i++)
            {
                    if (n1.charAt(i) != n2.charAt(i)) return false;
            }
            return true;
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
            int ans = 0 ,TempNum;

            for (int i = 0; i < arr.length; i++)
            {
                TempNum = number2Int(arr[i]);
                if (ans < TempNum) ans = TempNum;
            }
            return ans;
        }


        //עשינו בשיעור על רקורסיה - אחלה דבר לכותב את התקן של הפונקציה כמו שצריך
        public static int How_Many_Times_Char_In_Str (String str, char c)
        {
            if (str.isEmpty()) return 0;

            if (str.charAt(0) == c) return (How_Many_Times_Char_In_Str(str.substring(1), c) + 1);

            return (How_Many_Times_Char_In_Str(str.substring(1), c));
        }
}
