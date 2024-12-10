
# Ex1 - solution for assignment 1
This is a solution for Ex1 in Introduction to Computer Science in Java, 2025A - Ariel University, School of Computer Science.

The Java classs files will be found inside: "src/assignments/ex1"

## Introduction
The application accepts two numbers from the user, the numbers can be in different numeric bases between base 2 and base 16.

The software calculates the result of the sum and multiplication between the two numbers – and the user choose which numeric base (between base 2 and base 16) The results will be printed.

After this, the application prints the largest number among the numbers that user entered and the results of the multiplication and addition.


## Number format
Numbers are represented as `<number>'b'<base>`, for example:
- `135bA` ('135' in decimal base)
- `100111b2` ('100111' binary base)
- `12345b6` ('12345' in base 6)

Or just Numbers in decimal base <number>, for example:
- `404` ('404' in decimal base)
- `20001` ('20001' in decimal base)

### Invalid String
Any string is not considered a valid number if it does not follow the format. For example:

- `A223C` - no 'b'.
- `101b` - no base
- `-404bB` - negative number.
- `10.5` - not an natural number.
- `b2` - no number only number and 'b'.
- `33b8&^` - invalid chars.
- `404b A` - space is invalid.
  
    And more...


## Running the application
1. Compile the Java files: `Ex1.java` and `Ex1Main.java`
2. Run `Ex1Main.java`.
3. Insert formatted first number, second number and desired output base (in decimal base).


## Functions in Ex1
- `number2Int(String num)`: Converts a formatted number string to decimal
- `isNumber(String a)`: Validates if number is in the format
- `int2Number(int num, int base)`: Converts decimal number to specified base
- `equals(String n1, String n2)`: Checks if two formatted numbers are equivalent
- `maxIndex(String[] arr)`: Finds the index of the largest formatted number in an array
- `How_Many_Times_Char_In_Str`: Counts how many times a certain char appears in a string.

    
## JUnit tests
Comprehensive JUnit tests are provided in `Ex1Test.java`:

- `computeNumberTest` - tests `number2Int` and `int2Number`. 
- `isBasisNumberTest` - tests `isNumber`.
- `maxIndexTest` - tests `maxIndex`.
- `isEqualsTest` - tests `equals`.
- `how_much_chars_test` - tests `How_Many_Times_Char_In_Str`.
