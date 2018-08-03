import java.lang.reflect.Array;
import java.util.*;

public class LeetCode242ValidAnagram {
    public static void main(String[] args){
        System.out.println(isAnagram("rat","car"));
    }
    public static  boolean isAnagram(String s, String t) {
        int n = s.length();
        if(n != t.length()){
            return false;
        }
        Character[] s_array = new Character[n];
        Character[] t_array = new Character[n];
        for(int i = 0;i < n;i++){
            s_array[i] = s.charAt(i);
            t_array[i] = t.charAt(i);
        }
        Arrays.sort(s_array);
        Arrays.sort(t_array);
        for(int i = 0;i < n;i++){
            if(s_array[i] != t_array[i]){
                return false;
            }
        }
        return true;
    }
}
