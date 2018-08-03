import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode387FirstUniqueCharacterInAString {


    public static  void main(String[] args){
        String str = "cc";
        System.out.println(firstUniqChar(str));
    }


    public  static int firstUniqChar(String s) {
        if(s.length() == 0) return -1;
        Set<Character> charset = new HashSet<Character>();
        Set<Character> duplicateChar = new HashSet<Character>();
        for(int i = 0; i < s.length();i++){
            if(charset.contains(s.charAt(i))){
                duplicateChar.add(s.charAt(i));
            }
            charset.add(s.charAt(i));
        }
        for(int i = 0;i < s.length() ;i++){
            if(!duplicateChar.contains(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
