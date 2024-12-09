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
            String arrS [][] = {{"0b2", "0", "2bG"} , {"20CbE", "404", "EbG"}, {"153b7", "87" , "7bG"}, {"101", "101", "AbG"},{"AbC" , "10", "CbG"}};

            int value, base;
            String temp;
            for (int i = 0; i < arrS.length; i++)
            {
                //testing "number2Int" using "equals" function:
                assertTrue(Ex1.equals(arrS[i][0], arrS[i][1]));

                // testing "int2number"
                v = Ex1.number2Int(arrS[i][1]); //decimal number form string to int
                v2 = Ex1.number2Int(arrS[i][2]); //original base form string to int
                s2 = Ex1.int2Number(v,v2); // number in original base (str)

                assertEquals(arrS[i][0], s2);
            }
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA", "1011b2", "1011bA", "00b2", "0000bG", "DDAbG"};
            for (int i=0;i<good.length; i++) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"101b", "b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2" , "1907b2", "not", "10b 2", "4 04b5", "GGbG", "ABbJ", "ABb17", "0b1"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {
            //

            String num = "15678b9"; // this is check num/

            String [] str_Numbers = num.split("b");
            int Old_base = Integer.parseInt(str_Numbers[1],17);
            int ans = Integer.parseInt(str_Numbers[0],Old_base);


            assertEquals(Ex1.number2Int(num), ans);
           // implement this test
        }
        @Test
        void maxIndexTest() {
            String[] NumArr = {"1","123b6", "ABbG", "0bA", "1011b2", "1011bA"};
            for (int i=0;i<NumArr.length; i++) {
                int max = Ex1.maxIndex(NumArr);
                assertEquals(max, 1011);
            }
        }


        @Test
        void isEqualsTest() {
//            String [] ArrStr = {"hi this is me", "hi this is me"};
//            boolean ok = Ex1.equals(ArrStr[0], ArrStr[1]);
//            assertTrue(ok);
//
//            ArrStr = new String[]{"hi this is me", "hi this isn't me"};
//            ok = Ex1.equals(ArrStr[0], ArrStr[1]);
//            assertFalse(ok);
        }

        // Add additional test functions - test as much as you can.
    }
