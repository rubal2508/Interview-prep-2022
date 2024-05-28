import java.util.HashMap;

public class HelloWorld {

    public static void convertRoman(String s){

        System.out.println("Input String: " + s);

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        // System.out.println(map);

        int n = s.length();
        int i = 0;
        int total = 0;
        while(i<n){

            Character ch = s.charAt(i);
            System.out.println(i + " " + ch);

            // handle subtraction
            if(i<n-1){

                Character nextCh = s.charAt(i+1);
                System.out.println(nextCh);
                
                if((ch == 'I' && nextCh == 'V') || (ch == 'I' && nextCh == 'X')) {
                    total += -1;
                    System.out.println("subtraction of 1");
                    i++;
                }

                else if((ch == 'X' && nextCh == 'L') || (ch == 'X' && nextCh == 'C')) {
                    total += -10;
                    System.out.println("subtraction of 10");
                    i++;
                }

                else if((ch == 'C' && nextCh == 'D') || (ch == 'C' && nextCh == 'M')) {
                    total += -100;
                    System.out.println("subtraction of 100");
                    i++;
                }

            }
            // add
            System.out.println(i + " " + ch);
            ch = s.charAt(i);
            total += map.get(ch);
            i++;
        }

        System.out.println("Answer: "+ total);
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println("Hello, World!");
        convertRoman("MMXV");
        // convertRoman("IV");
        // convertRoman("VII");
    }
}


// javac -d target HelloWorld.java 
// java -cp target HelloWorld


/*

There are roman number I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.


III 
IV 
VII
IX
X
XXX
XXXVIII

XXIX
XXI

LI
CI

IV

LVIII
MCMXCIV
MMXV


*/