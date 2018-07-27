public class LeetCode647PalindromicSubstrings {

    public static void main(String[] args){
        System.out.println(countSubstrings("aaa"));
    }
    public static int countSubstrings(String s) {
        int n = s.length();
        int[][] pali = new int[n][n];
        for(int i = 0;i < n;i++){
            pali[i][i] = 1;
        }
        for(int i = 0; i < n - 1;i++){
            for(int j = n - 1;j >= i + 1;j--){
                if((new StringBuffer(s.substring(j - i - 1,j + 1)).reverse()).toString().equals(new StringBuffer(s.substring(j - i - 1,j + 1)).toString())){
                    if(i >= 1){// (j - i - 1) + 1 <= j - 1
                        pali[j - i - 1][j] = pali[j - i][j] + pali[j - i - 1][j - 1] - pali[j - i][j - 1] + 1;
                    }else{
                        pali[j - i - 1][j] = pali[j - i][j] + pali[j - i - 1][j - 1] + 1;
                    }
                }
                else{
                    if(i >= 1){
                        pali[j - i - 1][j] = pali[j - i][j] + pali[j - i - 1][j - 1] - pali[j - i][j - 1] ;
                    }
                    else{
                        pali[j - i - 1][j] = pali[j -i][j] + pali[j - i - 1][j - 1];
                    }
                }

            }

        }
        return pali[0][n - 1];
    }
}
