public class LeetCode344RerverseString {
    public String reverseString(String s) {
        String str = "";

        for(int i = s.length() - 1;i >= 0;i--){
            str = str.concat(String.valueOf(s.charAt(i)));
        }
        return str;
    }
}
