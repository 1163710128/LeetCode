import java.util.*;

public class LeetCode525ContiguousArray {

    public static void main(String[] args){
        int[] array = new  int[]{1,0,1,1,1,1};
        System.out.println(findMaxLength(array));
    }

    public static int findMaxLength(int[] nums) {
        int n = nums.length , curlen = 0 ,maxlen = 0;
        if(n == 0) return 0;
        int[] dis = new int[n];
        int [] count = new int[]{0,0};
        int[] index = new int[2 * n + 1];
        for(int i = 0;i < 2 * n + 1;i++){
            index[i] = - (2 * n + 1);
        }
        index[n] = 0;
        for(int i = 0;i < n; i++){
            count[nums[i]] += 1;
            dis[i] = count[1] - count[0];
            if(index[dis[i] + n] == - (2 * n + 1)){
                index[dis[i] + n ] = i;
            }else{
                if(dis[i]  == 0) {
                    curlen = i - index[dis[i] + n] + 1;
                }else{
                    curlen = i - index[dis[i] + n];
                }
                if(maxlen < curlen) maxlen = curlen;
            }
        }
        if(dis[n - 1] == 0) return n;
        return maxlen;
    }
}
