package assignments.ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        //I left the original tests, and added my own to avoid confusion.:
        void computeNumberTest() {
            //original testing:
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);

            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));

            //my testing:
            String FirstTest [][] = {{"0b2", "0"} , {"20CbE", "404"}, {"153b7", "87"}, {"101", "101"},{"AbC" , "10"}};

            for (int i = 0; i < FirstTest.length; i++)
            {
                //testing "number2Int" using "equals" function:
                assertTrue(Ex1.equals(FirstTest[i][0], FirstTest[i][1]));
            }
        }

        @Test
        void isBasisNumberTest() {
            // added a few of me own Strings...

            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA", "1011b2", "1011bA", "00b2", "0000bG", "DDAbG", "1000000000000000b2"};
            for (int i=0;i<good.length; i++) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }

            String[] not_good = {" ", "", "-404bB" ,"88.4b9" ,"101b", "b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2" , "1907b2", "not","12bAbG","10b 2", "4 04b5", "ABbJ", "ABb16", "0b1"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {
            // נתשמש בפונקציה אחרת למה בסיס G לא יעבוד
            String thirdTest [][] = {{"0b2", "0", "2bG"} , {"20CbE", "404", "EbG"}, {"153b7", "87" , "7bG"}, {"101", "101", "AbG"},{"AbC" , "10", "CbG"} ,{"15678b9", "10763", "9bG"} , {"f", "15", "GbG"}};
            int value, base;
            String temp;
            for (int i = 0; i < thirdTest.length; i++)
            {
                // testing "int2number" using "number2int"
                value = Ex1.number2Int(thirdTest[i][1]); //decimal number form string to int
                base = Ex1.number2Int(thirdTest[i][2]); //original base form string to int
                temp = Ex1.int2Number(value,base); // number in original base (str)

                assertEquals(thirdTest[i][0], temp);
            }
        }

        @Test
        void maxIndexTest() {
            String[] NumArr1 = {"1" ,"123b6", "ABbG", "0bA", "1011b2", "1011bA", "404", "-2001"};

            int max = Ex1.maxIndex(NumArr1);
            assertEquals(NumArr1[max], "1011bA");

            //let's try with invalid numbers:
            String[] NumArr2 = {"100b2", "abG", "10b3", "-10bC"};
            max = Ex1.maxIndex(NumArr2);
            assertEquals(NumArr2[max], "100b2");
        }

        @Test
        void isEqualsTest() {
            String [] arr1 = {"101", "65bG", "1100101b2" , "203b7" , "73bE" , "101bA"};
            for (int i = 1; i < arr1.length; i++)
            {
                boolean ok = Ex1.equals(arr1[i - 1], arr1[i]);
                assertTrue(ok);
            }

            //not equals numbers, encluding some invalid String
            String [] arr2 = {"101", "200bG", "56b7", "88bF", "10 bA", "2001bA" , "123bZ"};
            for (int i = 1; i < arr2.length; i++)
            {
                boolean not_ok = Ex1.equals(arr2[i - 1], arr2[i]);
                assertFalse(not_ok);
            }
        }

    @Test
    void how_much_chars_test() {
        String[] ArrChars_0 = {" ", "", "abts", "  test  "};
        String[] ArrChars_1 = {"b", "abct", "   b   t", "  one b  "};
        String[] ArrChars_2 = {"bb", "ttbbtft", "   bb  jkjk", "  one c  "};

        /// to finish

        int max = Ex1.How_Many_Times_Char_In_Str(ArrChars);
        assertEquals(ArrChars[max], "1011bA");
    }


}
