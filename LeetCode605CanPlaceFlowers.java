public class LeetCode605CanPlaceFlowers {
    public boolean canPlaceFlowers(int flowerbed[],int n){
        if(flowerbed.length == 1 && flowerbed[0] == 0) return true;
        int i = 0;
        while(i != flowerbed.length){
            if(i == 0){
                if(flowerbed[i] == 0 && flowerbed[1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            }else if(i == flowerbed.length - 1){
                if(flowerbed[i - 1] == 0 && flowerbed[i] == 0){
                    flowerbed[i] = 1;

                    n--;
                }
            }else{
                if(flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i+ 1] == 0){
                    flowerbed[i] = 1;
                    n--;
                }
            }
            i++;
            if(n <= 0) return true;
        }
        return false;
    }

}
