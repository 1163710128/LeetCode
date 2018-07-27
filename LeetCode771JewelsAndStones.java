import java.util.*;
public class LeetCode771JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        List<Character> list = new ArrayList<>();
        for(int i = 0;i < J.length();i++){
            list.add(J.charAt(i));
        }
        int count = 0;
        for(int i = 0;i < J.length();i++){
            for(int j = 0;j < S.length();j++){
                if(list.get(i).equals(S.charAt(j))) count++;
            }
        }
        return count;
    }
}
