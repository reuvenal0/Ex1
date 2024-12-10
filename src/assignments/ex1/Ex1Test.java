package assignments.ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** This JUnit class represents a very partial test class for Ex1.*/

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

            // My testing - Let's delve into each function separately (this way we can set up extreme cases):
            // First let's test number2int
            String SecondTest [][] = {{"0b2", "0"} , {"20CbE", "404"}, {"153b7", "87"}, {"101", "101"},{"AbC" , "10"}};

            for (int i = 0; i < SecondTest.length; i++)
            {
                //testing "number2Int" using "equals" function:
                assertTrue(Ex1.equals(SecondTest[i][0], SecondTest[i][1]));
            }

            // let's see if invalid String is -1:
            // our equal function can't work on invalid String, so we won't use it
            String ThirdTest [] = {" 5 4b2", null , "-44b8" , "trt!@"};
            for (int i = 0; i < ThirdTest.length; i++)
            {
                v = Ex1.number2Int(ThirdTest[i]);
                assertEquals(v,-1);
            }

            /* Now let's test int2number:
            let's build three arrays -
            1) int DecValues - some decimal values
            2) int NewBases - the bases we want to convert to
            3) String ArrNewNumbers - the desired result according to number format
            */
            int DecValues [] = {0,17,87,101,890,404,193056,65441,2001};
            int NewBases [] = {2,2,7,10,10,14,14,16,16};
            String ArrNewNumbers [] = {"0b2", "10001b2" , "153b7", "101", "890" ,"20CbE" ,"504DAbE" , "FFA1bG", "7D1bG"};

            for (int i =0; i < DecValues.length; i++)
            {
                String TempNewNum = Ex1.int2Number(DecValues[i], NewBases[i]);
                assertEquals(TempNewNum,ArrNewNumbers[i]);
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

            String[] not_good = {null, " ", "", "b" ,"A223C", "323G" ,"-404bB" ,"88.4b9" ,"101b", "b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2" , "1907b2", "not","12bAbG","10b 2", "4 04b5", "ABbJ", "ABb16", "0b1"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }

        @Test
        void maxIndexTest() {
            String[] NumArr1 = {"1" ,"123b6", "ABbG", "0bA", "1011b2", "1011bA", "404"};
            int max = Ex1.maxIndex(NumArr1);
            assertEquals(NumArr1[max], "1011bA");

            //let's try with one more exemple with invalid numbers also:
            String[] NumArr2 = {"100b2", "abG", "10b3", "-10bC", null , "-404.04b5"};
            max = Ex1.maxIndex(NumArr2);
            assertEquals(NumArr2[max], "100b2");
        }

        @Test
        void isEqualsTest() {
            // First array of numbers (str) that are equals:
            String [] arr1 = {"101", "65bG", "1100101b2" , "203b7" , "73bE" , "101bA"};
            for (int i = 1; i < arr1.length; i++)
            {
                boolean ok = Ex1.equals(arr1[i - 1], arr1[i]);
                assertTrue(ok);
            }

            // invalid number can't be equal to any number:
            assertFalse(Ex1.equals("3b2", "-1"));

            // Second array of numbers that are not equal numbers, including some invalid values:
            String [] arr2 = {"101", "200bG", "56b7", "88bF", "10 bA", "2001bA" , "123bZ", null};
            for (int i = 1; i < arr2.length; i++)
            {
                boolean not_ok = Ex1.equals(arr2[i - 1], arr2[i]);
                assertFalse(not_ok);
            }
        }

        @Test
        void how_much_chars_test() {
            // let's see if "How_Many_Times_Char_In_Str" knows how to correctly count how many times the char is present in a string:

            char b = 'b'; // we will count how much 'b' we got in some Strings

            // let's creat a two dimensional array: each line is the number of times 'b' is present in an String
            // [i][j] - so that i is the number of time 'b' is present: 0,1,2.
            String [][] Arr1 = {{null, " ", "", "ats", "  test  "}, {"b", "abct", "   b   t", " ^^&%$ one b  " , "bhjhjhj"} , {"bb", "ttbbtft", " ^^&  bb  jkjk", " b two  b  ", "bhhhjdb"}};
            for (int i = 0; i < Arr1.length; i++) {
                for (int j = 0; j < Arr1[i].length; j++) {
                    int count = Ex1.How_Many_Times_Char_In_Str(Arr1[i][j], b);
                    assertEquals(count,i);
                }
            }
        }
}
