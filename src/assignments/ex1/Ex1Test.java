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
        void computeNumberTest() {

            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);

            s2 = "0b2";
            v = Ex1.number2Int(s2);
            assertEquals(v,0);

            s2 = "1011b2";
            v = Ex1.number2Int(s2);
            assertEquals(v,11);

            s2 = "18b2";
            v = Ex1.number2Int(s2);
            assertEquals(v,-1);


            s2 = "b12";
            v = Ex1.number2Int(s2);
            assertEquals(v,-1);

            int num = 1011, base = 2;
            s2 = Ex1.int2Number(num,base);
            assertEquals(s2,"1111110011b2");


            String s10 = "1011bA"; //number in base 10
            v = Ex1.number2Int(s10); //get number to int
            s2 = Ex1.int2Number(v,2); //convert number to base 2
            int v2 = Ex1.number2Int(s2); // convert number to base 10
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,"1011bA"));
        }



        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA", "1011b2", "1011bA"};
            for (int i=0;i<good.length; i++) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"101b", "b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2" , "1907b2"};
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
