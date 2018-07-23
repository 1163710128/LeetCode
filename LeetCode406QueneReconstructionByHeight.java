import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode406QueneReconstructionByHeight {

    public static void main(String[] args){
        int[][] bless = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        /* [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]] */
        for(int i = 0 ;i < 6;i++){
            System.out.println(reconstructQueue(bless)[i][0] + "    " + reconstructQueue(bless)[i][1]);
        }
    }

    public static int[][] reconstructQueue(int[][] people) {//(h,k)
        int[][] recons = new int[people.length][2];
        // sort all points if k == 0, rank them in rising order
        int zero_k_count = 0;
        List<Integer> zero_k_list = new ArrayList<>();
        List<Integer> zero_k_indexList = new ArrayList<>();
        for(int i = 0;i < people.length;i++) {
            if (people[i][1] == 0) {
                zero_k_count++;
                zero_k_list.add(people[i][0]);
                zero_k_indexList.add(i);
            }
        }

        Collections.sort(zero_k_list);
        for(int i = 0 ;i < zero_k_indexList.size();i++){
            for(int j = 0;j < zero_k_indexList.size();j++){
                if(people[zero_k_indexList.get(j)][0] == zero_k_list.get(i)){
                    recons[i][0] = people[zero_k_indexList.get(j)][0];
                }
            }
        }

        // greedy strategy
        List<Integer> h_temp_list = new ArrayList<>(); /*store h*/
        List<Integer> k_temp_list = new ArrayList<>(); /*store k*/
        for(int i = 0; i < people.length;i++){
            if(people[i][1] != 0){
                h_temp_list.add(people[i][0]);
                k_temp_list.add(people[i][1]);
            }
        }

        List<Integer> h_list = new ArrayList<>();
        List<Integer> k_list = new ArrayList<>();
        for(int i = 0;i < zero_k_count;i++){
            h_list.add(recons[i][0]);
            k_list.add(0);
        }

        while(k_list.size() != people.length){
            // find point with max h and min k.
            int[] properArray = getQueuePerson(h_temp_list,k_temp_list);
            int front_count = 0;
            for(int i = 0;i < h_list.size();i++){
                if(h_list.get(i) >= properArray[0]){
                    front_count++;
                }
                if(front_count == properArray[1]){

                    h_list.add(i + 1, properArray[0]);
                    k_list.add(i + 1,properArray[1]);
                }
            }
        }

        for(int i = 0 ;i < people.length;i++){
            recons[i][0] = h_list.get(i);
            recons[i][1] = k_list.get(i);
        }
        return recons;
    }

    public static int[] getQueuePerson(List<Integer> h_list,List<Integer> k_list){
        int max_h = Collections.max(h_list);
        List<Integer> temp_k_list = new ArrayList<>();
        for(int i = 0;i < k_list.size();i++){
            if(h_list.get(i) == max_h){
                temp_k_list.add(k_list.get(i));
            }
        }
        int index = 1000;
        for(int i = 0;i < k_list.size();i++){
            if(k_list.get(i) == Collections.min(temp_k_list) && h_list.get(i) == max_h){
                index = i;
            }
        }
        int[] person = new int[2];
        person[0] = h_list.get(index);
        person[1] = k_list.get(index);
        h_list.remove(index);
        k_list.remove(index);
        return person;
    }

}
