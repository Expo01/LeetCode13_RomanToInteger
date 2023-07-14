import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
//create map with roman numeral as key and its value
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int ans = 0;
//for <length of string
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) { // check OOB. if for example 7 chars,
                // leength == 7. if crriteria says i must be less than 7-1 = 6, so cannot rrun when on max index
                // . if this is true and value at i<i+1
                ans -= m.get(s.charAt(i)); // subtract value associatd with the key
            } else { //else add value
                ans += m.get(s.charAt(i));
            }
        }

        return ans;
    }
}




// big ugly method that is not the correct way. too many conditionals
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i< s.length(); i++){
            if (s.charAt(i) == 'M'){ sum += 1000;}
            if (s.charAt(i) == 'D'){sum += 500;}
            if (s.charAt(i) == 'C'){
                if(s.charAt(i+1) < s.length()-1 && s.charAt(i+1) == 'D'){
                    sum += 400;
                } else if (s.charAt(i+1) < s.length()-1 && s.charAt(i+1) =='M'){
                    sum += 900;
                } else { sum += 100;}
            }
            if (s.charAt(i) == 'X'){
                if (s.charAt(i+1) < s.length()-1 && s.charAt(i+1) =='L'){
                    sum += 40;
                } else if (s.charAt(i+1) < s.length()-1 && s.charAt(i+1) =='C'){
                    sum += 90;
                } else {sum += 10;}
            }
            if (s.charAt(i) == 'V'){sum += 5;}
            if (s.charAt(i)== 'I'){
                if (s.charAt(i+1) < s.length()-1 && s.charAt(i+1) =='V'){
                    sum += 4;
                } else if (s.charAt(i+1) < s.length()-1 && s.charAt(i+1) =='X'){
                    sum += 9;
                } else {sum += 1;}
            }
        }
        return sum;
    }
}
// could say if for example if 's.charAt(i) == 'I' and s.charAt(i+1) == V || == X, then minus 1. but this is still very lengthy
// this is better though where i'm taking advantage of subtraction and not assigning values of 4, 9, 40, 90, etc.