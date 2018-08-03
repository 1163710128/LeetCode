import java.util.ArrayList;
import java.util.List;
public class LeetCode389FindTheDifference {
    public static void main(String[] args){
        String  s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s,t));
    }
    public static char findTheDifference(String s, String t) {
        List<Character> sList = new ArrayList<>();
        List<Character> tList = new ArrayList<>();
        for(int i = 0; i< s.length();i++){
            sList.add(s.charAt(i));
        }
        for(int i = 0; i < t.length();i++){
            tList.add(t.charAt(i));
        }
        for(int i = 0 ;i < s.length();i++){
            tList.remove(sList.get(i));
        }
        return tList.get(0);
    }
}
